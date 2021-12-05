<h1>Word Count</h1>

<h2>Requirements</h2>
- Java JDK 8 or Above Installed and Environmental Variables Set
- Maven Installed and Environmental Variables Set

<h2>Dependencies Used</h2>

Only dependencies as of now are junit 5 and log4j2 for logging capabilities. As of now the program has been built entierly from core java 8

    <dependency>
      <groupId>org.junit.jupiter</groupId>
      <artifactId>junit-jupiter-api</artifactId>
      <version>5.8.1</version>
      <scope>test</scope>
    </dependency>
    <dependency>
      <groupId>org.junit.jupiter</groupId>
      <artifactId>junit-jupiter-engine</artifactId>
      <version>5.8.1</version>
      <scope>test</scope>
    </dependency>
    <dependency>
      <groupId>org.junit.jupiter</groupId>
      <artifactId>junit-jupiter-params</artifactId>
      <version>5.8.1</version>
      <scope>test</scope>
    </dependency>
    <dependency>
      <groupId>org.apache.logging.log4j</groupId>
      <artifactId>log4j-core</artifactId>
      <version>2.14.1</version>
    </dependency>

When building the program, ensure that these dependencies have been downloaded into your .m2 folder correctly

<h2> How To Build and Run</h2>
<h3>Command Line From JAR File</h3>
1. Go to https://github.com/Larvact/WordCountSynalogik and either clone the repository or download the zip and extract onto your machine

2. Go to the root directory of the project on the cmd. Should be {Path to Your Java Projects}/WordCountSynalogik
3. Run the command "mvn dependency:resolve"
4. Run the command "mvn clean package"
5. Once packaged go to the target directory on the cmd. There should be two .jar files
6. On the cmd in the target directory run the following command: java -jar Synalogik-Word-Count.jar {ABSOLUTE_PATH_OF_FILE_YOU_WANT_TO_COUNT}
7. Results of the count will be printed to the cmd

<h3>Intellij IDE</h3>
1. Go to https://github.com/Larvact/WordCountSynalogik and either clone the repository or download the zip and extract onto your machine
2. Open Intellij and go to File -> New Project From Existing Sources and select the root directory of the project on the cmd. Should be {Path to Your Java Projects}/WordCountSynalogik
3. Go to the POM file and click on the refresh maven button to download the dependencies of the project   
4. Locate the "ApplicationEntry.java" class at the project location src/main/java/org/toby/ApplicationEntry.java and open it
5. Replace the "new WordCount(args[0])" call with "new WordCount({ABSOLUTE_PATH_OF_FILE_YOU_WANT_TO_COUNT})"
6. Run from that class
7. Results of the count will be printed to the terminal

<h2>How the Program Works</h2>
<h3>High Level Overview</h3>
1. Each string in the inputted file is delimited by any number of spaces
2. Each read string has transformations that are conducted it to remove punctuation and undesired symbols from the beginning and end of the string in order to create a potential word
3. A final check on the word is made at the end of the transformation to see if it contains any alphanumeric characters. If it does not then it is filtered away as not a word.
4. After checks are complete the length of the word is retrieved 
5. All words from the file are injected into a list whereby calculations are made on all in order to get the resultant display

<h3>Word Examples</h3>
It is difficult for me to account for all assumptions in the examples. For more specific detail I would suggest looking at the src/main/java/org/toby/wordcount/word/wordtransformers package which deals with all the transforms currently active. These can easily be extended or removed as per business logic by implementing the interface and adding it to the factory and enum

Current implemented common examples as follows:

1. (Test) - Transforms to the word Test with length 4
2. £20.00 - Transforms to the word £20.00 with length 6, currently currency symbols, numbers and punctuation within alphanumerics count to the length
3. test, - Transforms to the word test with length 4 (punctuation follows same pattern)
4. ~20 - Transforms to the word 20 with length 2 (punctuation same pattern)
5. \#test - Transforms to the word test with length 4
6. can't - Transforms to the word can't with length 5
7. 20/12/2021 - Transforms to the word 20/12/2021 with length 10
8. 20% - Transforms to the word 20% with length 3
9. "test" - Transforms to the word test with length 4
10. test: - Transforms to the word test with length 4
11. "(test)" - Transforms to the word test with length 4. Multiple punctuation either side of a word are removed too
12. & - Transforms to the word & with length 1

<h3>Non Word Examples</h3>
1. \*******************
2. \#$%%^$^"£$"£%
3. Anything that does not contain an alphanumeric

For the specific regex used to create these rules look at the ENUM located at src/main/java/org/toby/wordcount/utils/Regex.java

<h2>Limitations</h2>
1. The program is inaccurate for non-English languages
2. Can only handle one file at a time
   
<h2>Improvements</h2>
1. Test coverage not yet at 100%, more unit testing required to achieve this. Mostly with negative testing
2. Have a BA to review the base assumptions of a word and add/amend/remove transformations as applicable
3. Instead of writing the result to the console, generate a results text file
4. Implement code to handle multiple file inputs
5. Introduce an inversion of control framework like the Spring Ioc container to make dependency injection look cleaner
