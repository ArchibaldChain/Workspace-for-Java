package WordCloud;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class GetSuitFont {
    private String[] words;
    private int[] frequency;
    private String name = "宋体";
    private int max;
    private int min;

    /**
     * Give the String to initialize the class
     * @param all a
     */
    public GetSuitFont(String all) {
        int number = 300;
        String a[] = all.split("\n");
        ArrayList<String> al1 = new ArrayList<>();
        ArrayList<Integer> al2 = new ArrayList<>();

        int j = 0;
        for(String b : a){
            String c[] = b.split(",");
            al1.add(c[0]);
            al2.add(Integer.valueOf(c[1]));
            j++;
            if (j == number) break;
        }
        words = al1.toArray(new String[al1.size()]);

        j = 0;
        int c[]= new int[al2.size()];
        for (Integer i: al2) {
            c[j] = i;
            j++;
            if (j == number) break;
        }
        frequency = c;
        max = this.frequency[0];
        min = this.frequency[this.frequency.length-1];
    }

    public Font getSuitableFont(int frequency){
        if (frequency < min) return null;

        int size;
        size = frequency*105/
                        (max-min)
                + 25 - min*105/(max-min);
        return new Font(name, Font.PLAIN, size);
    }

    public Color getSuitableColor(int frequency){
        if (frequency < this.frequency[this.frequency.length-1]) return null;

        double a = ((double) frequency - (double)this.frequency[this.frequency.length-1]) /
                ((double)this.frequency[0] - (double)this.frequency[this.frequency.length-1]);
        if (a >= 0.6){
            System.out.println("Color 1");
            return new Color(255, 165, 0);
        }
        else if (a >= 0.3){
            System.out.println("Color 2");
            return new Color(255, 140, 0);
        }
        else if (a >= 0.08){
            System.out.println(" Color 3");
            return new Color(238, 118, 33);
        }
        else{
            System.out.println(" Color 4");
            return new Color(139, 69, 19);
        }
        /*
        255, 255,224
        250, 250, 210
        255, 255, 240


         */


//        Random random = new Random();
//        int red;
//        red = frequency*(-55)/
//                (max-min)
//                + 200 + min*55/(max-min);
//        red = random.nextInt(255)+1;
//
//        int green;
//        green = frequency*(-50)/
//                (max-min)
//                + 175 + min*50/(max-min);
//        green = random.nextInt(255)+1;
//
//        int blue;
//        blue = random.nextInt(255)+1;
//
//
//        return new Color(red, green, blue);
    }

    public void makeSizeSmaller(){
        for (int i = 0; i < frequency.length; i++) {
            frequency[i] = frequency[i] - 4;
        }
    }

    public String[] getWords() {
        return words;
    }

    public int[] getFrequency() {
        return frequency;
    }
}
