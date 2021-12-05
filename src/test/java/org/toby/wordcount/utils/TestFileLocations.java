package org.toby.wordcount.utils;

public enum TestFileLocations {

    SINGLE_SENTENCE_FILE("src/test/resources/singleSentenceWordCountTestFile.txt"),
    BIBLE_DAILY("src/test/resources/bibleDaily.txt"),
    BLANK_FILE("src/test/resources/blankFile.txt"),
    NO_WORDS_FILE("src/test/resources/noWords.txt"),
    FILE_NOT_EXIST_PATH("src/test/resources/fileDoesNotExist.txt");

    private String filePath;

    TestFileLocations(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }
}
