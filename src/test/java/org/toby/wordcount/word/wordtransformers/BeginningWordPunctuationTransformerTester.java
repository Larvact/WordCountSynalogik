package org.toby.wordcount.word.wordtransformers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BeginningWordPunctuationTransformerTester {

    private static WordTransformer transformer;

    @BeforeAll
    private static void setup(){
        transformer = new BeginningWordPunctuationTransformer();
    }

    @Test
    void ensureSpecialANDDoesNotTransform(){
        String inputtedString = "&";
        String actualResult = transformer.validate(inputtedString);
        Assertions.assertEquals(inputtedString, actualResult);
    }

    @Test
    void ensureValidWordDoesNotTransform(){
        String inputtedString = "Test";
        String actualResult = transformer.validate(inputtedString);
        Assertions.assertEquals(inputtedString, actualResult);
    }

    @Test
    void ensureWordWithSinglePunctuationAtStartTransforms(){
        String inputtedString = "?Test";
        String actualResult = transformer.validate(inputtedString);
        Assertions.assertEquals("Test", actualResult);
    }

    @Test
    void ensureWordWithMultiplePunctuationAtStartTransforms(){
        String inputtedString = "!.,[?Test";
        String actualResult = transformer.validate(inputtedString);
        Assertions.assertEquals("Test", actualResult);
    }

    @Test
    void ensureWordWithPunctuationAtEndRemains(){
        String inputtedString = "Test!.,;:";
        String actualResult = transformer.validate(inputtedString);
        Assertions.assertEquals("Test!.,;:", actualResult);
    }
}
