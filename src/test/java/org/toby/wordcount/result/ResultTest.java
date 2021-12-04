package org.toby.wordcount.result;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.toby.wordcount.result.analysers.WordCounter;
import org.toby.wordcount.result.analysers.WordSizeAverager;
import org.toby.wordcount.result.analysers.WordSizeFrequency;
import org.toby.wordcount.result.analysers.WordsCalculator;
import org.toby.wordcount.utils.TestFileLocations;
import org.toby.wordcount.utils.WordsTestData;
import org.toby.wordcount.word.dto.Word;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

class ResultTest {

    private static Path dummyTestPath;
    private static Result result;
    private static String expectedOutput;

    @BeforeAll
    private static void setup() {
        dummyTestPath = Paths.get(TestFileLocations.BLANK_FILE.getFilePath());
        List<Word> words = WordsTestData.getWords();
        WordCounter wordCounter = new WordCounter(words);
        WordSizeAverager wordSizeAverager = new WordSizeAverager(words, wordCounter);
        WordSizeFrequency wordSizeFrequency = new WordSizeFrequency(words);
        WordsCalculator wordsCalculator = new WordsCalculator(wordCounter, wordSizeAverager, wordSizeFrequency);
        result = new Result(dummyTestPath, wordsCalculator);
        setExpectedOutput();
    }

    private static void setExpectedOutput(){
        StringBuilder outputBuilder = new StringBuilder();
        outputBuilder.append("\n")
                .append("---------------------------------")
                .append(dummyTestPath.getFileName())
                .append("---------------------------------")
                .append("\n")
                .append("\n")
                .append("Word Count = 9")
                .append("\n")
                .append("Average Word Length = 4.556")
                .append("\n")
                .append("The number of words of length 1 is 1")
                .append("\n")
                .append("The number of words of length 2 is 1")
                .append("\n")
                .append("The number of words of length 3 is 1")
                .append("\n")
                .append("The number of words of length 4 is 2")
                .append("\n")
                .append("The number of words of length 5 is 2")
                .append("\n")
                .append("The number of words of length 7 is 1")
                .append("\n")
                .append("The number of words of length 10 is 1")
                .append("\n")
                .append("The most frequently occurring word length is 2, for word lengths of 4 & 5")
                .append("\n")
                .append("\n")
                .append("---------------------------------------------------------------------------------------------------");
        expectedOutput = outputBuilder.toString();
    }

    @Test
    void ensureOutputIsCorrect(){
        Assertions.assertEquals(expectedOutput, result.getOutput());
    }
}
