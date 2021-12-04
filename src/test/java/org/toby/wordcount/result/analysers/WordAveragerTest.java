package org.toby.wordcount.result.analysers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.toby.wordcount.utils.WordsTestData;
import org.toby.wordcount.word.dto.Word;

import java.util.List;

public class WordAveragerTest {

    private static List<Word> words;
    private static WordCounter wordCounterSingleSentenceFile;
    private static WordSizeAverager wordAveragerSingleSentenceFile;

    @BeforeAll
    private static void setupWordCounter(){
        words = WordsTestData.getWords();
        wordCounterSingleSentenceFile = new WordCounter(words);
        wordAveragerSingleSentenceFile = new WordSizeAverager(words, wordCounterSingleSentenceFile);
    }

    @Test
    void ensureWordCountIsCorrectSingleSentenceFile(){
        Assertions.assertEquals(4.556, wordAveragerSingleSentenceFile.getWordSizeAverage());
    }
}
