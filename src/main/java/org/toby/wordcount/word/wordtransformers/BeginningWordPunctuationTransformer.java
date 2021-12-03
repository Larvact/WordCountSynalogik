package org.toby.wordcount.word.wordtransformers;

import org.toby.wordcount.utils.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BeginningWordPunctuationTransformer implements WordTransformer {

    private static Pattern beginningOfWordPattern = Pattern.compile(Regex.PUNCTUATION_START_OF_WORD.getRegex());

    @Override
    public String validate(String string) {
        Matcher matcher = beginningOfWordPattern.matcher(string);
        String punctuationRemoved = string;
        while (matcher.find()){
            punctuationRemoved = punctuationRemoved.substring(1);
            matcher = beginningOfWordPattern.matcher(punctuationRemoved);
        }
        return punctuationRemoved;
    }
}
