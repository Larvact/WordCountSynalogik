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

    @BeforeAll
    private static void setupFilePaths(){
        singleSentenceWordCountTestFilePath = Paths.get(TestFileLocations.SINGLE_SENTENCE_FILE_PATH.getFilePath());
    }

    @Test
    void ensureCorrectNumberOfWordsAreReadFromSingleSentenceFile(){
        WordReader reader = new WordReader(singleSentenceWordCountTestFilePath);
        List<Word> wordList = reader.read();
        Assertions.assertEquals(9, wordList.size());
    }

}
