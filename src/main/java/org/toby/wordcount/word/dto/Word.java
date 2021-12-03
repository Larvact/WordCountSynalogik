package org.toby.wordcount.word.dto;

import org.toby.wordcount.word.wordtransformers.WordTransformer;
import java.util.List;

public class Word {

    private String delimitedString;
    private List<WordTransformer> wordTransformers;
    private String word;

    public Word(String delimitedString, List<WordTransformer> wordTransformers) {
        this.delimitedString = delimitedString;
        this.wordTransformers = wordTransformers;
        setWord();
    }

    private void setWord(){
        String transformedWord = this.delimitedString;
        for(WordTransformer wordTransformer : this.wordTransformers){
            transformedWord = wordTransformer.validate(transformedWord);
        }
        this.word = transformedWord;
    }

    public String getWord(){
        return this.word;
    }

    public int getWordLength() {
        return this.word.length();
    }
}
