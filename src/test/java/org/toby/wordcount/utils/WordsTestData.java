package org.toby.wordcount.utils;

import org.toby.wordcount.word.dto.Word;
import org.toby.wordcount.word.wordtransformers.WordTransformersFactory;

import java.util.ArrayList;
import java.util.List;

public class WordsTestData {

    static {setWords();}

    private static List<Word> words;

    private static void setWords(){
        words = new ArrayList<>();
        words.add(new Word("Hello", WordTransformersFactory.getWordTransformers()));
        words.add(new Word("world", WordTransformersFactory.getWordTransformers()));
        words.add(new Word("&", WordTransformersFactory.getWordTransformers()));
        words.add(new Word("good", WordTransformersFactory.getWordTransformers()));
        words.add(new Word("morning.", WordTransformersFactory.getWordTransformers()));
        words.add(new Word("The", WordTransformersFactory.getWordTransformers()));
        words.add(new Word("date", WordTransformersFactory.getWordTransformers()));
        words.add(new Word("is", WordTransformersFactory.getWordTransformers()));
        words.add(new Word("18/05/2016", WordTransformersFactory.getWordTransformers()));
    }

    public static List<Word> getWords(){
        return words;
    }
}
