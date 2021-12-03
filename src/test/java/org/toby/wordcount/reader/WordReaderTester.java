package org.toby.wordcount.reader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.toby.wordcount.utils.TestFileLocations;
import org.toby.wordcount.word.dto.Word;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class WordReaderTester {

    private static Path singleSentenceWordCountTestFilePath;
    private static Path bibleDailyWordCountTestFilePath;

    @BeforeAll
    private static void setupFilePaths(){
        singleSentenceWordCountTestFilePath = Paths.get(TestFileLocations.SINGLE_SENTENCE_FILE_PATH.getFilePath());
        bibleDailyWordCountTestFilePath = Paths.get(TestFileLocations.BIBLE_DAILY.getFilePath());
    }

    @Test
    void ensureCorrectNumberOfWordsAreReadFromSingleSentenceFile(){
        WordReader reader = new WordReader(singleSentenceWordCountTestFilePath);
        List<Word> wordList = reader.read();
        Assertions.assertEquals(9, wordList.size());
    }

    @Test
    void ensureCorrectNumberOfWordsAreReadFromBibleDailyFile(){
        WordReader reader = new WordReader(bibleDailyWordCountTestFilePath);
        List<Word> wordList = reader.read();
        int currentExpectedCount = 793094; //Need to verify assumptions and make changes where necessary to get a fully accurate word expected count
        Assertions.assertEquals(currentExpectedCount, wordList.size());
    }

}
