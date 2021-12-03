package org.toby.wordcount.utils;

public enum TestFileLocations {

    SINGLE_SENTENCE_FILE_PATH("src/test/resources/singleSentenceWordCountTestFile.txt");

    private String filePath;

    TestFileLocations(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }
}
