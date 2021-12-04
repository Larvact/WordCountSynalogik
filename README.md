#Word Count

## Requirements
- Java JDK 8 or Above Installed and Environmental Variables Set
- Maven Installed and Environmental Variables Set

## How To Run
###Command Line From JAR File
1. Go to https://github.com/Larvact/WordCountSynalogik and either clone the repository or download the zip and extract onto your machine.
2. Go to the root directory of the project on the cmd. Should be {Path to Your Java Projects}/WordCountSynalogik
3. Run the command "mvn clean package"
4. Once packaged go to the target directory on the cmd, if you were to go to the same destination on the file explorer then you should see two .jar files
5. On the cmd in the target directory run the following command: java -jar Synalogik-Word-Count.jar {ABSOLUTE_PATH_OF_FILE_YOU_WANT_TO_COUNT}
6. Results of the count will be printed to the cmd under the execution

###Intellij IDE
1. Go to https://github.com/Larvact/WordCountSynalogik and either clone the repository or download the zip and extract onto your machine.
2. Open Intellij and go to File -> New Project From Existing Sources and select the root directory of the project on the cmd. Should be {Path to Your Java Projects}/WordCountSynalogik
3. Locate the "ApplicationEntry.java" class at the project location src/main/java/org/toby/ApplicationEntry.java and open it
4. Replace the "new WordCount(args[0])" call with "new WordCount({ABSOLUTE_PATH_OF_FILE_YOU_WANT_TO_COUNT})"
5. Run from that class
6. Results of the count will be printed to the terminal

##How the Program Works
1. Each string in the inputted file is delimited by any number of spaces
2. Each read string has transformations that are conducted it to remove punctuation and undesired symbols from the beginning and end of the string in order to create a potential word
3. A final check on the word is made at the end of the transformation to see if it contains any alphanumeric characters. If it does not then it is filtered away as not a word.
4. After checks are complete the length of the word is retrieved and calculations made on all words and their lengths are conducted in order to get the resultant data

##Word Examples
It is difficult for me to account for all assumptions in the examples. For more specific detail I would suggest looking at the src/main/java/org/toby/wordcount/word/wordtransformers package which deals with all the transforms currently active. These can easily be extended or removed as per business logic by implementing the interface and adding it to the factory and enum. Common examples as follows:

1. (Test) - Transforms to the word Test with length 4
2. £20.00 - Transforms to the word £20.00 with length 6, currently currency symbols, numbers and punctuation within alphanumerics count to the length
3. test, - Transforms to the word test with length 4 (all punctuation follows suite)
4. ~20 - Transforms to the word 20 with length 2 (all punctuation follows suite except for currencies and percentage symbol)
5. \#test - Transforms to the word test with length 4
6. can't - Transforms to the word can't with length 5
7. 20/12/2021 - Transforms to the word 20/12/2021 with length 10
8. 20% - Transforms to the word 20% with length 3
9. "test" - Transforms to the word test with length 4
10. test: - Transforms to the word test with length 4
11. "(test)" - Transforms to the word test with length 4. Multiple punctuation either side of a word are removed too
12. & - Transforms to the word & with length 1

##Non Word Examples
1. \*******************
2. \#$%%^$^"£$"£%
3. Anything that does not contain an alphanumeric

For the specific regex used to create these rules look at the ENUM located at src/main/java/org/toby/wordcount/utils/Regex.java

##Limitations/Improvements
1. Currently the program will be inaccurate for non-English languages
2. Can only handle one file at a time. Possible to extend to multiple files
3. Test coverage not yet at 100%. A little bit more unit testing to achieve this. Mostly with negative testing.
4. Have a BA to review the base assumptions of a word and add/amend/remove transformations as applicable
5. Instead of writing the result to the console, generate a results text file
