package org.toby.wordcount.word.wordtransformers;

import org.toby.wordcount.utils.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EndingWordPunctuationTransformer implements WordTransformer{

    private static final Pattern endOfWordPattern = Pattern.compile(Regex.PUNCTUATION_END_OF_WORD.getRegexString());

    @Override
    public String validate(String string) {
        Matcher matcher = endOfWordPattern.matcher(string);
        String punctuationRemoved = string;
        while (matcher.find()){
            punctuationRemoved = punctuationRemoved.substring(0,punctuationRemoved.length() - 1);
            matcher = endOfWordPattern.matcher(punctuationRemoved);
        }
        return punctuationRemoved;
    }
}
