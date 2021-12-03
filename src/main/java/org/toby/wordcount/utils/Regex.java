package org.toby.wordcount.utils;

public enum Regex {

    WHITE_SPACE_DELIMITER(" +"),
    WORD_VALIDATION("[A-Za-z0-9&]"),
    PUNCTUATION_END_OF_WORD("[!\"#$'()*+,-.\\/:;<=>?@\\[\\]^_`{|}~]$"),
    PUNCTUATION_START_OF_WORD("^[!\"#'()*+,-.\\/:;<=>?@\\[\\]^_`{|}~]");

    private String regex;

    Regex(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
