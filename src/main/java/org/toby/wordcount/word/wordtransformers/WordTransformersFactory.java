package org.toby.wordcount.word.wordtransformers;

import java.util.ArrayList;
import java.util.List;

public class WordTransformersFactory {

    static {
        setWordTransformers();
    }

    private WordTransformersFactory() {
    }

    private static List<WordTransformer> wordTransformers;

    public static List<WordTransformer> getWordTransformers() {
        return wordTransformers;
    }

    private static void setWordTransformers(){
        wordTransformers = new ArrayList<>();
        wordTransformers.add(getWordTransformer(WordTransformerEnum.START_OF_WORD_PUNCTUATION));
        wordTransformers.add(getWordTransformer(WordTransformerEnum.END_OF_WORD_PUNCTUATION));
        wordTransformers.add(getWordTransformer(WordTransformerEnum.WORD_VALIDATION));
    }

    private static WordTransformer getWordTransformer(WordTransformerEnum validatorType){
        if(validatorType.equals(WordTransformerEnum.START_OF_WORD_PUNCTUATION)){
            return new BeginningWordPunctuationTransformer();
        }
        else if(validatorType.equals(WordTransformerEnum.END_OF_WORD_PUNCTUATION)){
            return new EndingWordPunctuationTransformer();
        }
        else if(validatorType.equals(WordTransformerEnum.WORD_VALIDATION)){
            return new WordValidationTransformer();
        }
        throw new IllegalArgumentException("Validator of type " + validatorType + " does not have an implementation. Please implement a new class of this type from the Validator interface and add it here, to the conditional.");
    }
}
