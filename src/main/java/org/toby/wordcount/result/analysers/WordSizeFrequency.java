package org.toby.wordcount.result.analysers;

import org.toby.wordcount.word.dto.Word;

import java.util.*;

public class WordSizeFrequency {

    private final List<Word> words;
    private Map<Integer, Integer> wordSizeFrequencyMap;
    private List<Integer> mostFrequentWordLengths;
    private int maximumWordFrequency;

    public WordSizeFrequency(List<Word> words) {
        this.words = words;
        setWordSizeFrequencyMap();
        setMostFrequentWordLengths();
        setMaximumWordFrequency();
    }

    public Map<Integer, Integer> getWordSizeFrequencyMap() {
        return this.wordSizeFrequencyMap;
    }

    public List<Integer> getMostFrequentWordLengths() {
        return this.mostFrequentWordLengths;
    }

    public int getMaximumWordFrequency() {
        return this.maximumWordFrequency;
    }

    private void setWordSizeFrequencyMap() {
        this.wordSizeFrequencyMap = new HashMap<>();
        for (Word word : this.words) {
            int currentWordLength = word.getWordStringLength();
            if (this.wordSizeFrequencyMap.containsKey(currentWordLength)) {
                int previousFrequency = this.wordSizeFrequencyMap.get(currentWordLength);
                int newFrequency = previousFrequency + 1;
                this.wordSizeFrequencyMap.put(currentWordLength, newFrequency);
            } else {
                this.wordSizeFrequencyMap.put(currentWordLength, 1);
            }
        }
    }

    private void setMostFrequentWordLengths() {
        this.mostFrequentWordLengths = new ArrayList<>();
        int maximumLengthFrequency = 0;
        for(Map.Entry<Integer, Integer> wordLengthFrequencyPair: this.wordSizeFrequencyMap.entrySet()){
            int currentWordLength = wordLengthFrequencyPair.getKey();
            int currentWordLengthFrequency = wordLengthFrequencyPair.getValue();
            if (currentWordLengthFrequency > maximumLengthFrequency) {
                this.mostFrequentWordLengths.clear();
                this.mostFrequentWordLengths.add(currentWordLength);
                maximumLengthFrequency = currentWordLengthFrequency;
            } else if (currentWordLengthFrequency == maximumLengthFrequency) {
                this.mostFrequentWordLengths.add(currentWordLength);
            }
        }
    }

    private void setMaximumWordFrequency(){
        this.maximumWordFrequency = this.wordSizeFrequencyMap.get(this.mostFrequentWordLengths.get(0));
    }
}
