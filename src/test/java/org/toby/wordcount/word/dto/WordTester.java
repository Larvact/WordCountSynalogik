package org.toby.wordcount.word.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.toby.wordcount.word.wordtransformers.WordTransformer;
import org.toby.wordcount.word.wordtransformers.WordTransformersFactory;

import java.util.List;

public class WordTester {

    private static List<WordTransformer> wordTransformers;

    @BeforeAll
    private static void setupWordTransformers(){
        wordTransformers = WordTransformersFactory.getWordTransformers();
    }


    @Test
    void ensureLengthOfWordWithPunctuationBothSidesIsCorrect(){
        String inputtedString = ";'[]Test.,";
        Word word = new Word(inputtedString, wordTransformers);
        Assertions.assertEquals(4, word.getWordLength());
    }

    @Test
    void ensureLengthOfWordHelloIsCorrect(){
        String inputtedString = "Hello";
        Word word = new Word(inputtedString, wordTransformers);
        Assertions.assertEquals(5, word.getWordLength());
    }

    @Test
    void ensureLengthOfWordWorldIsCorrect(){
        String inputtedString = "world";
        Word word = new Word(inputtedString, wordTransformers);
        Assertions.assertEquals(5, word.getWordLength());
    }

    @Test
    void ensureLengthOfWordSpecialIsCorrect(){
        String inputtedString = "&";
        Word word = new Word(inputtedString, wordTransformers);
        Assertions.assertEquals(1, word.getWordLength());
    }

    @Test
    void ensureLengthOfWordGoodIsCorrect(){
        String inputtedString = "good";
        Word word = new Word(inputtedString, wordTransformers);
        Assertions.assertEquals(4, word.getWordLength());
    }

    @Test
    void ensureLengthOfWordMorningFullstopIsCorrect(){
        String inputtedString = "morning.";
        Word word = new Word(inputtedString, wordTransformers);
        Assertions.assertEquals(7, word.getWordLength());
    }

    @Test
    void ensureLengthOfWordTheIsCorrect(){
        String inputtedString = "The";
        Word word = new Word(inputtedString, wordTransformers);
        Assertions.assertEquals(3, word.getWordLength());
    }

    @Test
    void ensureLengthOfWordDateIsCorrect(){
        String inputtedString = "date";
        Word word = new Word(inputtedString, wordTransformers);
        Assertions.assertEquals(4, word.getWordLength());
    }

    @Test
    void ensureLengthOfWordIsIsCorrect(){
        String inputtedString = "is";
        Word word = new Word(inputtedString, wordTransformers);
        Assertions.assertEquals(2, word.getWordLength());
    }

    @Test
    void ensureLengthOfADateIsCorrect(){
        String inputtedString = "18/05/2016";
        Word word = new Word(inputtedString, wordTransformers);
        Assertions.assertEquals(10, word.getWordLength());
    }

    @Test
    void ensureTextThatIsNotAWordHasZeroWordLength(){
        String inputtedString = "*********************";
        Word word = new Word(inputtedString, wordTransformers);
        Assertions.assertEquals(0, word.getWordLength());
    }

    @Test
    void ensurePunctuationWithinAWordCountsToTheLength(){
        String inputtedString = "can't";
        Word word = new Word(inputtedString, wordTransformers);
        Assertions.assertEquals(5, word.getWordLength());
    }

    @Test
    void ensurePoundCurrencyWordLengthIsCorrect(){
        String inputtedString = "£30.00";
        Word word = new Word(inputtedString, wordTransformers);
        Assertions.assertEquals(6, word.getWordLength());
    }

    @Test
    void ensureANumberPercentageWordLengthIsCorrect(){
        String inputtedString = "30%";
        Word word = new Word(inputtedString, wordTransformers);
        Assertions.assertEquals(3, word.getWordLength());
    }
}
