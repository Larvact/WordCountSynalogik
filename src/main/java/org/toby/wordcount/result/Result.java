package org.toby.wordcount.result;

import org.toby.wordcount.result.analysers.WordsCalculator;

import java.nio.file.Path;
import java.util.Map;
import java.util.List;

public class Result {

    private final String fileName;
    private final WordsCalculator wordsCalculator;
    private String result;

    public Result(Path path, WordsCalculator wordsCalculator) {
        this.fileName = path.getFileName().toString();
        this.wordsCalculator = wordsCalculator;
        setResult();
    }

    private void setResult(){
        StringBuilder resultBuilder = new StringBuilder();
        addFileNameToResultBuild(resultBuilder);
        addWordCountToResultBuild(resultBuilder);
        addAverageToResultBuild(resultBuilder);
        addWordLengthFrequencyToResultBuild(resultBuilder);
        addMostFrequentOccurringLengthToResultBuild(resultBuilder);
        addFooterToResultBuild(resultBuilder);
        this.result = resultBuilder.toString();
    }

    private void addFileNameToResultBuild(StringBuilder builder){
        builder.append("---------------------------------")
                .append(this.fileName)
                .append("---------------------------------")
                .append("\n")
                .append("\n");
    }

    private void addWordCountToResultBuild(StringBuilder builder){
        builder.append("Word Count = ")
                .append(this.wordsCalculator.getWordCount())
                .append("\n");
    }

    private void addAverageToResultBuild(StringBuilder builder){
        builder.append("Average Word Length = ")
                .append(this.wordsCalculator.getWordSizeAverage())
                .append("\n");
    }

    private void addWordLengthFrequencyToResultBuild(StringBuilder builder){
        for(Map.Entry<Integer, Integer> wordLengthFrequencyPair : this.wordsCalculator.getWordSizeFrequencyMap().entrySet()){
            builder.append("The number of words of length ")
                    .append(wordLengthFrequencyPair.getKey())
                    .append(" is ")
                    .append(wordLengthFrequencyPair.getValue())
                    .append("\n");
        }
    }

    private void addMostFrequentOccurringLengthToResultBuild(StringBuilder builder){
        List<Integer> mostFrequentWordLengths = this.wordsCalculator.getMostFrequentWordLengths();
        builder.append("The most frequently occurring word length is ")
                .append(this.wordsCalculator.getMaximumWordFrequency())
                .append(", for word lengths of ");
        for(int wordLengthIndex = 0; wordLengthIndex < mostFrequentWordLengths.size() - 1; wordLengthIndex++){
            builder.append(mostFrequentWordLengths.get(wordLengthIndex))
                    .append(" ");
        }
        builder.append("& ")
                .append(mostFrequentWordLengths.get(mostFrequentWordLengths.size() - 1));
    }

    private void addFooterToResultBuild(StringBuilder builder){
        builder.append("\n")
                .append("\n")
                .append("---------------------------------");
    }

    public String getResult() {
        return result;
    }
}
