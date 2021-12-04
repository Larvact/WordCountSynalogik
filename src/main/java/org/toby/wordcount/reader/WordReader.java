package org.toby.wordcount.reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.toby.wordcount.utils.Regex;
import org.toby.wordcount.word.dto.Word;
import org.toby.wordcount.word.wordtransformers.WordTransformersFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WordReader {

    private static final Logger LOG = LogManager.getLogger(WordReader.class);
    private final Path path;

    public WordReader(Path path) {
        this.path = path;
    }

    public List<Word> read(){
        List<Word> wordsInFile = new ArrayList<>();
        try(BufferedReader reader = Files.newBufferedReader(this.path)){
            String line = reader.readLine();
            if(line == null){
                LOG.error(MessageFormat.format("The File on Path {0} Does Not Contain any Lines. Please Check and Re-input a File With Text Data Lines and Try Again", this.path));
                throw new IllegalArgumentException(MessageFormat.format("The File on Path {0} Does Not Contain any Lines. Please Check and Re-input a File With Text Data Lines and Try Again", this.path));
            }
            while(line != null){
                String[] delimitedStringList = line.split(Regex.WHITE_SPACE_DELIMITER.getRegexString());
                for (String delimitedString : delimitedStringList) {
                    Word currentWord = new Word(delimitedString, WordTransformersFactory.getWordTransformers());
                    wordsInFile.add(currentWord);
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            LOG.error(MessageFormat.format("The File on Path {0} Does Not Exist on Your System. Please Check and Re-input a Valid File Path to the Program and Try Again.", this.path));
            throw new IllegalArgumentException(MessageFormat.format("The File on Path {0} Does Not Exist on Your System. Please Check and Re-input a Valid File Path to the Program and Try Again.", this.path));
        }
        wordsInFile = filterOutNonWords(wordsInFile);
        checkReadWordsIsNonEmpty(wordsInFile);
        return wordsInFile;
    }

    private List<Word> filterOutNonWords(List<Word> words){
        return words.stream().filter(word -> word.getWordStringLength() > 0).collect(Collectors.toList());
    }

    private void checkReadWordsIsNonEmpty(List<Word> words){
        if(words.isEmpty()){
            LOG.error(MessageFormat.format("The File on Path {0} Does Not Have any Words. Please Check and Re-input a File Path to a File With Words to the Program and Try Again.", this.path));
            throw new IllegalArgumentException(MessageFormat.format("The File on Path {0} Does Not Have any Words. Please Check and Re-input a File Path to a File With Words to the Program and Try Again.", this.path));
        }
    }
}