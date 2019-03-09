package project;

/**
 * main is for the test Method
 *
 * FreCoun is the method
 *
 * input source and writingPath
 * write down the frequency
 *
 */
public class FrequencyCounter {

    private String wordsFrequency;

    public FrequencyCounter(String words) {
        wordsFrequency = CountingFreq.FrequcencyCounter(words);
    }


    public void writingFrequency(String writingPath){
        FileIO.fileWriter(writingPath, wordsFrequency);
    }

    public void writingFrequency(){
        String writingPath = "WordFrequency/wordFreq.txt";
        FileIO.fileWriter(writingPath, wordsFrequency);
    }

    public String getWordsFrequency() {
        return wordsFrequency;
    }
}
