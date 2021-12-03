package org.toby.wordcount.word.wordtransformers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordTransformationFactoryTester {

    //Not a dynamic test. In future look to use reflection to get the number of enums within the WordTransformerEnum and inject that into the expected result.
    @Test
    void ensureCorrectNumberOfTransformationObjectsArePresentInTheGeneratedListOfTransformers(){
        Assertions.assertEquals(3, WordTransformersFactory.getWordTransformers().size());
    }

}
