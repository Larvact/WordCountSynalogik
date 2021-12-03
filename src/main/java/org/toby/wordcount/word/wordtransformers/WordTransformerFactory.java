package org.toby.wordcount.word.wordtransformers;

public class WordTransformerFactory {

    public static WordTransformer getValidator(WordTransformerEnum validatorType){
        if(validatorType.equals(WordTransformerEnum.PUNCTUATION)){
            return new BeginningWordPunctuationTransformer();
        }
        else if(validatorType.equals(WordTransformerEnum.WORD)){
            return new WordValidationTransformer();
        }
        throw new IllegalArgumentException("Validator of type " + validatorType + " does not have an implementation. Please implement a new class of this type from the Validator interface and add it here, to the conditional.");
    }

}
