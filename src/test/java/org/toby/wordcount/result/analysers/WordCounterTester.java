package org.toby.wordcount.result.analysers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.toby.wordcount.reader.WordReader;
import org.toby.wordcount.utils.TestFileLocations;
import org.toby.wordcount.word.dto.Word;


import java.nio.file.Paths;
import java.util.List;

public class WordCounterTester {

    private static List<Word> singleSentenceWords;
    private static WordCounter wordCounterSingleSentenceFile;

    @BeforeAll
    private static void setupWordCounter(){
        WordReader reader = new WordReader(Paths.get(TestFileLocations.SINGLE_SENTENCE_FILE_PATH.getFilePath()));
        singleSentenceWords = reader.read();
        wordCounterSingleSentenceFile = new WordCounter(singleSentenceWords);
    }

    @Test
    void ensureWordCountIsCorrectSingleSentenceFile(){
        Assertions.assertEquals(9, wordCounterSingleSentenceFile.getWordCount());
    }
}
