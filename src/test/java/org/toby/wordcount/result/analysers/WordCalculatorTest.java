package org.toby.wordcount.result.analysers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.toby.wordcount.utils.WordsTestData;
import org.toby.wordcount.word.dto.Word;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCalculatorTest {

    private static List<Word> words;
    private static WordsCalculator wordsCalculator;
    private static List<Integer> expectedMostFrequentWordLengths;
    private static Map<Integer, Integer> expectedWordSizeFrequencyMap;

    @BeforeAll
    private static void setupCalculator(){
        setExpectedMostFrequentWordLengths();
        setExpectedWordSizeFrequencyMap();
        words = WordsTestData.getWords();
        WordCounter counter = new WordCounter(words);
        wordsCalculator = new WordsCalculator(counter, new WordSizeAverager(words, counter), new WordSizeFrequency(words));
    }

    private static void setExpectedMostFrequentWordLengths(){
        expectedMostFrequentWordLengths = new ArrayList<>();
        expectedMostFrequentWordLengths.add(4);
        expectedMostFrequentWordLengths.add(5);
    }

    private static void setExpectedWordSizeFrequencyMap(){
        expectedWordSizeFrequencyMap = new HashMap<>();
        expectedWordSizeFrequencyMap.put(1,1);
        expectedWordSizeFrequencyMap.put(2,1);
        expectedWordSizeFrequencyMap.put(3,1);
        expectedWordSizeFrequencyMap.put(4,2);
        expectedWordSizeFrequencyMap.put(5,2);
        expectedWordSizeFrequencyMap.put(7,1);
        expectedWordSizeFrequencyMap.put(10,1);
    }

    @Test
    void ensureWordCountIsCorrect(){
        Assertions.assertEquals(9, wordsCalculator.getWordCount());
    }

    @Test
    void ensureWordCountIsCorrectSingleSentenceFile(){
        Assertions.assertEquals(4.556, wordsCalculator.getWordSizeAverage());
    }

    @Test
    void ensureMaximumWordFrequencyIsCorrect(){
        Assertions.assertEquals(2, wordsCalculator.getMaximumWordFrequency());
    }

    @Test
    void ensureMostFrequentWordLengthsIsCorrect(){
        Assertions.assertEquals(expectedMostFrequentWordLengths, wordsCalculator.getMostFrequentWordLengths());
    }

    @Test
    void ensureWordSizeFrequencyMapIsCorrect(){
        Assertions.assertEquals(expectedWordSizeFrequencyMap, wordsCalculator.getWordSizeFrequencyMap());
    }
}