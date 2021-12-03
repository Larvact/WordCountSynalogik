package org.toby.wordcount.word.wordtransformers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class WordValidationTransformerTester {

    private static WordTransformer transformer;

    @BeforeAll
    private static void setup(){
        transformer = new WordValidationTransformer();
    }

    @Test
    void ensureSpecialANDPassesWordValidation(){
        String inputtedString = "&";
        String actualResult = transformer.validate(inputtedString);
        Assertions.assertEquals(inputtedString, actualResult);
    }

    @Test
    void ensureHelloPassesWordValidation(){
        String inputtedString = "Hello";
        String actualResult = transformer.validate(inputtedString);
        Assertions.assertEquals(inputtedString, actualResult);
    }

    @Test
    void ensureWorldPassesWordValidation(){
        String inputtedString = "world";
        String actualResult = transformer.validate(inputtedString);
        Assertions.assertEquals(inputtedString, actualResult);
    }

    @Test
    void ensureGoodPassesWordValidation(){
        String inputtedString = "good";
        String actualResult = transformer.validate(inputtedString);
        Assertions.assertEquals(inputtedString, actualResult);
    }

    @Test
    void ensureMorningFullstopPassesWordValidation(){
        String inputtedString = "morning.";
        String actualResult = transformer.validate(inputtedString);
        Assertions.assertEquals(inputtedString, actualResult);
    }

    @Test
    void ensureThePassesWordValidation(){
        String inputtedString = "The";
        String actualResult = transformer.validate(inputtedString);
        Assertions.assertEquals(inputtedString, actualResult);
    }

    @Test
    void ensureDatePassesWordValidation(){
        String inputtedString = "date";
        String actualResult = transformer.validate(inputtedString);
        Assertions.assertEquals(inputtedString, actualResult);
    }

    @Test
    void ensureIsPassesWordValidation(){
        String inputtedString = "is";
        String actualResult = transformer.validate(inputtedString);
        Assertions.assertEquals(inputtedString, actualResult);
    }

    @Test
    void ensureADatePassesWordValidation(){
        String inputtedString = "18/05/2016";
        String actualResult = transformer.validate(inputtedString);
        Assertions.assertEquals(inputtedString, actualResult);
    }

    @Test
    void ensureSpecialCharStarDoesNotPassWordValidation(){
        String inputtedString = "***********************";
        ensureSpecialCharDoesNotPassWordValidation(inputtedString);
    }

    @Test
    void ensureSpecialCharTildaDoesNotPassWordValidation(){
        String inputtedString = "~";
        ensureSpecialCharDoesNotPassWordValidation(inputtedString);
    }

    @Test
    void ensureSpecialCharHashtagDoesNotPassWordValidation(){
        String inputtedString = "#";
        ensureSpecialCharDoesNotPassWordValidation(inputtedString);
    }

    private void ensureSpecialCharDoesNotPassWordValidation(String string){
        String actualResult = transformer.validate(string);
        Assertions.assertEquals("", actualResult);
    }
}
