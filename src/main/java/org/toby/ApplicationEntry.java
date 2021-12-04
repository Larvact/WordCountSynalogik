package org.toby;

import org.toby.wordcount.WordCount;

import java.nio.file.Paths;

/**
 * Hello world!
 *
 */
public class ApplicationEntry
{
    public static void main( String[] args )
    {
        WordCount wordCount = new WordCount("src/test/resources/bibleDaily.txt");
    }
}
