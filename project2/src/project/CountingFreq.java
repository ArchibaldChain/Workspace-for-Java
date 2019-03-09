package project;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;


public class CountingFreq {

    /**
     * @copyRight Archibald Chain
     * @param text
     * @return  return a HashMap that contains the value and key.
     */
    public static String FrequcencyCounter(String text){

        String[] words = text.split("\\|");

        HashMap<String,Counter> freqCount = new HashMap();
        StringBuilder sb = new StringBuilder();

        for (String m: words) {
            if(m.length() == 1)
                continue;
            if(freqCount.containsKey(m)){
                freqCount.get(m).Count ++;
            }
            else
                freqCount.put(m,new Counter());  //add
        }

        Iterator iter = freqCount.entrySet().iterator();

        TreeSet treeSet = new TreeSet();
        while (iter.hasNext())
        {
            Map.Entry entry = (Map.Entry) iter.next();
            Object key = entry.getKey();
            Object val = entry.getValue();
            if(((Counter)val).Count ==1)
                continue;
            WordFrequency wordFrequency = new WordFrequency((String)key,((Counter)val).getCount());
            treeSet.add(wordFrequency);
        }

        Iterator iterator = treeSet.iterator();
        while(iterator.hasNext()){
            WordFrequency wordFrequency = (WordFrequency)iterator.next();

            sb.append( wordFrequency.getWords()+","+wordFrequency.getFrequency()+"\n");
        }
        return sb.toString();
    }
}

class Counter{
    int Count = 1;
    @Override
    public String toString() {
        return Integer.toString(Count);
    }

    public int getCount() {
        return Count;
    }
}

class WordFrequency implements Comparable {
    private String words;
    private int frequency;

    public WordFrequency(String words, int frequency) {
        this.words = words;
        this.frequency = frequency;
    }

    public String getWords() {
        return words;
    }

    public int getFrequency() {
        return frequency;
    }

    @Override
    public int compareTo(Object obj){
        WordFrequency wf = (WordFrequency)obj;
        if(wf.frequency < this.frequency){
            return -1;
        }
        if(wf.frequency > this.frequency){
            return 1;
        }
        if(wf.frequency == this.frequency){
            return this.words.compareTo(wf.words);
        }
        return 0;
    }


}


