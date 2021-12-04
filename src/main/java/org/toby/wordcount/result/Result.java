package org.toby.wordcount.result;

import org.toby.wordcount.result.analysers.WordsCalculator;

import java.nio.file.Path;
import java.util.Map;
import java.util.List;

public class Result {

    private final String fileName;
    private final WordsCalculator wordsCalculator;
    private String output;

    public Result(Path path, WordsCalculator wordsCalculator) {
        this.fileName = path.getFileName().toString();
        this.wordsCalculator = wordsCalculator;
        setOutput();
    }

    private void setOutput(){
        StringBuilder outputBuilder = new StringBuilder();
        addFileNameToOutputBuild(outputBuilder);
        addWordCountToOutputBuild(outputBuilder);
        addAverageToOutputBuild(outputBuilder);
        addWordLengthFrequencyToOutputBuild(outputBuilder);
        addMostFrequentOccurringLengthToOutputBuild(outputBuilder);
        addFooterToOutputBuild(outputBuilder);
        this.output = outputBuilder.toString();
    }

    private void addFileNameToOutputBuild(StringBuilder builder){
        builder.append("\n")
                .append("---------------------------------")
                .append(this.fileName)
                .append("---------------------------------")
                .append("\n")
                .append("\n");
    }

    private void addWordCountToOutputBuild(StringBuilder builder){
        builder.append("Word Count = ")
                .append(this.wordsCalculator.getWordCount())
                .append("\n");
    }

    private void addAverageToOutputBuild(StringBuilder builder){
        builder.append("Average Word Length = ")
                .append(this.wordsCalculator.getWordSizeAverage())
                .append("\n");
    }

    private void addWordLengthFrequencyToOutputBuild(StringBuilder builder){
        for(Map.Entry<Integer, Integer> wordLengthFrequencyPair : this.wordsCalculator.getWordSizeFrequencyMap().entrySet()){
            builder.append("The number of words of length ")
                    .append(wordLengthFrequencyPair.getKey())
                    .append(" is ")
                    .append(wordLengthFrequencyPair.getValue())
                    .append("\n");
        }
    }

    private void addMostFrequentOccurringLengthToOutputBuild(StringBuilder builder){
        List<Integer> mostFrequentWordLengths = this.wordsCalculator.getMostFrequentWordLengths();
        builder.append("The most frequently occurring word length is ")
                .append(this.wordsCalculator.getMaximumWordFrequency());
        if(mostFrequentWordLengths.size() == 1){
            builder.append(", for word length of ")
                    .append(mostFrequentWordLengths.get(0));
        }
        else {
            builder.append(", for word lengths of ");
            for (int wordLengthIndex = 0; wordLengthIndex < mostFrequentWordLengths.size() - 1; wordLengthIndex++) {
                builder.append(mostFrequentWordLengths.get(wordLengthIndex))
                        .append(" ");
            }
            builder.append("& ")
                    .append(mostFrequentWordLengths.get(mostFrequentWordLengths.size() - 1));
        }
    }

    private void addFooterToOutputBuild(StringBuilder builder){
        builder.append("\n")
                .append("\n")
                .append("---------------------------------------------------------------------------------------------------");
    }

    public String getOutput() {
        return output;
    }
}
