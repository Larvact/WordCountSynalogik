package org.toby.wordcount.result.analysers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.toby.wordcount.reader.WordReader;
import org.toby.wordcount.utils.TestFileLocations;
import org.toby.wordcount.word.dto.Word;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSizeFrequencyTester {

    private static List<Word> singleSentenceWords;
    private static WordSizeFrequency wordSizeFrequencySingleSentenceFile;
    private static List<Integer> expectedMostFrequentWordLengthsSingleSentenceFile;
    private static Map<Integer, Integer> expectedWordSizeFrequencyMap;

    @BeforeAll
    private static void setupWordCounter(){
        setExpectedMostFrequentWordLengthsSingleSentenceFile();
        setExpectedWordSizeFrequencyMapSingleSentenceFile();
        WordReader reader = new WordReader(Paths.get(TestFileLocations.SINGLE_SENTENCE_FILE_PATH.getFilePath()));
        singleSentenceWords = reader.read();
        wordSizeFrequencySingleSentenceFile = new WordSizeFrequency(singleSentenceWords);
    }

    private static void setExpectedMostFrequentWordLengthsSingleSentenceFile(){
        expectedMostFrequentWordLengthsSingleSentenceFile = new ArrayList<>();
        expectedMostFrequentWordLengthsSingleSentenceFile.add(4);
        expectedMostFrequentWordLengthsSingleSentenceFile.add(5);
    }

    private static void setExpectedWordSizeFrequencyMapSingleSentenceFile(){
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
    void ensureMaximumWordFrequencyIsCorrect(){
        Assertions.assertEquals(2, wordSizeFrequencySingleSentenceFile.getMaximumWordFrequency());
    }

    @Test
    void ensureMostFrequentWordLengthsSingleSentenceFileIsCorrect(){
        Assertions.assertEquals(expectedMostFrequentWordLengthsSingleSentenceFile, wordSizeFrequencySingleSentenceFile.getMostFrequentWordLengths());
    }

    @Test
    void ensureWordSizeFrequencyMapSingleSentenceFileIsCorrect(){
        Assertions.assertEquals(expectedWordSizeFrequencyMap, wordSizeFrequencySingleSentenceFile.getWordSizeFrequencyMap());
    }
}
