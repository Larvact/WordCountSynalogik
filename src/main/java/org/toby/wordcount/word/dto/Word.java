package org.toby.wordcount.word.dto;

import org.toby.wordcount.word.wordtransformers.WordTransformer;
import java.util.List;

public class Word {

    private final String delimitedString;
    private final List<WordTransformer> wordTransformers;
    private String wordString;

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
        this.wordString = transformedWord;
    }

    public int getWordStringLength() {
        return this.wordString.length();
    }
}
