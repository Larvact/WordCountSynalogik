package org.toby.wordcount.result.analysers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.toby.wordcount.utils.WordsTestData;
import org.toby.wordcount.word.dto.Word;
import java.util.List;

public class WordCounterTest {

    private static List<Word> words;
    private static WordCounter wordCounterSingleSentenceFile;

    @BeforeAll
    private static void setupWordCounter(){
        words = WordsTestData.getWords();
        wordCounterSingleSentenceFile = new WordCounter(words);
    }

    @Test
    void ensureWordCountIsCorrectSingleSentenceFile(){
        Assertions.assertEquals(9, wordCounterSingleSentenceFile.getWordCount());
    }
}
