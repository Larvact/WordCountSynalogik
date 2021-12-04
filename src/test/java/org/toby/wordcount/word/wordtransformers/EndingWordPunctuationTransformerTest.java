package org.toby.wordcount.word.wordtransformers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class EndingWordPunctuationTransformerTest {

    private static WordTransformer transformer;

    @BeforeAll
    private static void setup(){
        transformer = new EndingWordPunctuationTransformer();
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
    void ensureWordWithSinglePunctuationAtEndTransforms(){
        String inputtedString = "Test?";
        String actualResult = transformer.validate(inputtedString);
        Assertions.assertEquals("Test", actualResult);
    }

    @Test
    void ensureWordWithMultiplePunctuationAtEndTransforms(){
        String inputtedString = "Test!.,[?";
        String actualResult = transformer.validate(inputtedString);
        Assertions.assertEquals("Test", actualResult);
    }

    @Test
    void ensureWordWithPunctuationAtStartRemains(){
        String inputtedString = "!.,;:Test";
        String actualResult = transformer.validate(inputtedString);
        Assertions.assertEquals("!.,;:Test", actualResult);
    }
}
