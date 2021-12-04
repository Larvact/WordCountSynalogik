package org.toby.wordcount.word.wordtransformers;

import org.toby.wordcount.utils.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordValidationTransformer implements WordTransformer {

    private static final Pattern pattern = Pattern.compile(Regex.WORD_VALIDATION.getRegexString());

    @Override
    public String validate(String string) {
        Matcher matcher = pattern.matcher(string);
        if(!matcher.find()){
            return "";
        }
        return string.trim();
    }
}
