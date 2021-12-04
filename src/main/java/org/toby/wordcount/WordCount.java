package org.toby.wordcount;

import org.toby.wordcount.reader.WordReader;
import org.toby.wordcount.result.Result;
import org.toby.wordcount.result.analysers.WordCounter;
import org.toby.wordcount.result.analysers.WordSizeAverager;
import org.toby.wordcount.result.analysers.WordSizeFrequency;
import org.toby.wordcount.result.analysers.WordsCalculator;
import org.toby.wordcount.result.writer.ConsoleWriter;
import org.toby.wordcount.result.writer.Writer;
import org.toby.wordcount.word.dto.Word;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class WordCount {

    private Path filePath;
    private WordReader reader;
    private List<Word> readWords;
    private WordsCalculator wordsCalculator;
    private Result result;
    private Writer consoleWriter;

    public WordCount(String filePath) {
        constructWords(filePath);
        constructCalculator();
        constructResult();
        printResultToConsole();
    }

    private void constructWords(String filePath){
        this.filePath = Paths.get(filePath);
        this.reader = new WordReader(this.filePath);
        this.readWords = this.reader.read();
    }

    private void constructCalculator(){
        WordCounter wordCounter = new WordCounter(this.readWords);
        WordSizeAverager wordSizeAverager = new WordSizeAverager(this.readWords, wordCounter);
        WordSizeFrequency wordSizeFrequency = new WordSizeFrequency(this.readWords);
        this.wordsCalculator = new WordsCalculator(wordCounter, wordSizeAverager, wordSizeFrequency);
    }

    private void constructResult(){
        this.result = new Result(this.filePath, this.wordsCalculator);
    }

    private void printResultToConsole(){
        this.consoleWriter = new ConsoleWriter();
        this.consoleWriter.write(this.result.getResult());
    }
}
