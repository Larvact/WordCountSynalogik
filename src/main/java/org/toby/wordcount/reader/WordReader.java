package org.toby.wordcount.reader;

import org.toby.wordcount.utils.Regex;
import org.toby.wordcount.word.dto.Word;
import org.toby.wordcount.word.wordtransformers.WordTransformersFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WordReader {

    private final Path path;

    public WordReader(Path path) {
        this.path = path;
    }

    public List<Word> read(){
        List<Word> wordsInFile = new ArrayList<>();
        try(BufferedReader reader = Files.newBufferedReader(this.path)){
            String line = reader.readLine();
            while(line != null){
                String[] delimitedStringList = line.split(Regex.WHITE_SPACE_DELIMITER.getRegexString());
                for (String delimitedString : delimitedStringList) {
                    Word currentWord = new Word(delimitedString, WordTransformersFactory.getWordTransformers());
                    wordsInFile.add(currentWord);
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        wordsInFile = filterOutNonWords(wordsInFile);
        return wordsInFile;
    }

    private List<Word> filterOutNonWords(List<Word> words){
        return words.stream().filter(word -> word.getWordStringLength() > 0).collect(Collectors.toList());
    }
}