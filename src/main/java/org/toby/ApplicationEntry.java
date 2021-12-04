package org.toby;

import org.toby.wordcount.WordCount;

public class ApplicationEntry
{
    public static void main( String[] args )
    {
        new WordCount("src/test/resources/blankFile.txt");
    }
}
