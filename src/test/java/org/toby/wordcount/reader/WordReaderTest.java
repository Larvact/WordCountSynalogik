package org.toby.wordcount.reader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.toby.wordcount.utils.TestFileLocations;
import org.toby.wordcount.word.dto.Word;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class WordReaderTest {

    private static Path singleSentenceWordCountTestFilePath;
    private static Path bibleDailyWordCountTestFilePath;
    private static Path blankTestFilePath;
    private static Path noWordsTestFilePath;
    private static Path fileNotExistPath;
    private WordReader reader;

    @BeforeAll
    private static void setupFilePaths(){
        singleSentenceWordCountTestFilePath = Paths.get(TestFileLocations.SINGLE_SENTENCE_FILE.getFilePath());
        bibleDailyWordCountTestFilePath = Paths.get(TestFileLocations.BIBLE_DAILY.getFilePath());
        blankTestFilePath = Paths.get(TestFileLocations.BLANK_FILE.getFilePath());
        noWordsTestFilePath = Paths.get(TestFileLocations.NO_WORDS_FILE.getFilePath());
        fileNotExistPath = Paths.get(TestFileLocations.FILE_NOT_EXIST_PATH.getFilePath());
    }

    @Test
    void ensureCorrectNumberOfWordsAreReadFromSingleSentenceFile(){
        reader = new WordReader(singleSentenceWordCountTestFilePath);
        List<Word> wordList = reader.read();
        Assertions.assertEquals(9, wordList.size());
    }

    @Test
    void ensureCorrectNumberOfWordsAreReadFromBibleDailyFile(){
        reader = new WordReader(bibleDailyWordCountTestFilePath);
        List<Word> wordList = reader.read();
        int currentExpectedCount = 793094; //Need to verify assumptions and make changes where necessary to get a fully accurate word expected count
        Assertions.assertEquals(currentExpectedCount, wordList.size());
    }

    @Test
    void ensureArgumentExceptionIsRaisedWhenReadingABlankFile(){
        reader = new WordReader(blankTestFilePath);
        Assertions.assertThrows(IllegalArgumentException.class, () -> reader.read());
    }

    @Test
    void ensureArgumentExceptionIsRaisedWhenReadingAFileWithoutWords(){
        reader = new WordReader(noWordsTestFilePath);
        Assertions.assertThrows(IllegalArgumentException.class, () -> reader.read());
    }

    @Test
    void ensureArgumentExceptionIsRaisedWhenAttemptingToReadAFileThatDoesNotExist(){
        reader = new WordReader(fileNotExistPath);
        Assertions.assertThrows(IllegalArgumentException.class, () -> reader.read());
    }

}
