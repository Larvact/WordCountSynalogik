package org.toby.wordcount.result.analysers;

import org.toby.wordcount.word.dto.Word;

import java.util.List;

public class WordCounter {

    private final List<Word> words;

    public WordCounter(List<Word> words) {
        this.words = words;
    }

    public int getWordCount(){
        return this.words.size();
    }
}
