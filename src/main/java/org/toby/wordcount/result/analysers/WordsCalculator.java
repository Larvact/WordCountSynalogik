package org.toby.wordcount.result.analysers;

import java.util.Map;
import java.util.List;

public class WordsCalculator {

    private final WordCounter wordCounter;
    private final WordSizeAverager wordAverager;
    private final WordSizeFrequency wordSizeFrequency;

    public WordsCalculator(WordCounter wordCounter, WordSizeAverager wordAverager, WordSizeFrequency wordSizeFrequency) {
        this.wordCounter = wordCounter;
        this.wordAverager = wordAverager;
        this.wordSizeFrequency = wordSizeFrequency;
    }

    public int getWordCount(){
        return this.wordCounter.getWordCount();
    }

    public double getWordSizeAverage(){
        return this.wordAverager.getWordSizeAverage();
    }

    public Map<Integer, Integer> getWordSizeFrequencyMap(){
        return this.wordSizeFrequency.getWordSizeFrequencyMap();
    }

    public int getMaximumWordFrequency(){
        return this.wordSizeFrequency.getMaximumWordFrequency();
    }
    public List<Integer> getMostFrequentWordLengths(){
        return this.wordSizeFrequency.getMostFrequentWordLengths();
    }
}
