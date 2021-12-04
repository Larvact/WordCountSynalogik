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
        int currentMaximumLengthFrequency = 0;
        for (int wordLength : this.wordSizeFrequencyMap.keySet()) {
            int wordLengthFrequency = this.wordSizeFrequencyMap.get(wordLength);
            if (wordLengthFrequency > currentMaximumLengthFrequency) {
                this.mostFrequentWordLengths.clear();
                this.mostFrequentWordLengths.add(wordLength);
                currentMaximumLengthFrequency = wordLengthFrequency;
            } else if (wordLengthFrequency == currentMaximumLengthFrequency) {
                this.mostFrequentWordLengths.add(wordLength);
            }
        }
        Collections.sort(this.mostFrequentWordLengths);
    }

    private void setMaximumWordFrequency(){
        this.maximumWordFrequency = this.wordSizeFrequencyMap.get(this.mostFrequentWordLengths.get(0));
    }
}
