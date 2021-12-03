package org.toby.wordcount.result.analysers;

import org.toby.wordcount.word.dto.Word;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class WordSizeAverager {

    private final List<Word> words;
    private WordCounter wordCounter;

    public WordSizeAverager(List<Word> words, WordCounter wordCounter) {
        this.words = words;
        this.wordCounter = wordCounter;
    }

    public double getWordSizeAverage(){
        long sumOfLettersOrNumbers = 0;
        for(Word word : this.words){
            sumOfLettersOrNumbers = sumOfLettersOrNumbers + word.getWordLength();
        }
        BigDecimal averageWordSize = BigDecimal.valueOf(sumOfLettersOrNumbers/ (double) wordCounter.getWordCount()).setScale(3, RoundingMode.HALF_UP);
        return averageWordSize.doubleValue();
    }
}
