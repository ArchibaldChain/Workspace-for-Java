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
    private int sizeMax;
    private int sizeMin;
    private String shape;

    /**
     * Give the String to initialize the class
     * @param all a
     */
    public GetSuitFont(String all, String shape) {
        this.shape = shape;
        int number = 2000;
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

        setShpae();
    }

    public void setShpae(){
        if (shape.equals("Ellipse")){
            sizeMax = 130;
            sizeMin = 23;
        }
        else {
            sizeMax = 80;
            sizeMin = 18;
        }
    }


    public Font getSuitableFont(int frequency){
        if (frequency < min) return null;
        if (max == min) return new Font(name, Font.PLAIN, 30);
        int size;
        size = frequency*(sizeMax-sizeMin)/
                        (max-min)
                + sizeMin - min*(sizeMax-sizeMin)/(max-min);
        return new Font(name, Font.PLAIN, size);
    }

    public Color getSuitableColor(int frequency){
        if (frequency < this.frequency[this.frequency.length-1]) return null;
        if (max == min) return Color.green;
        if(shape.equals("Star")){
            return Orange(frequency);
        } else if (shape.equals("Heart")){
            return (Red(frequency));
        } else {
            return Blue(frequency);
        }
    }



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

    private Color Orange(int frequency) {
        double a = ((double) frequency - (double) this.frequency[this.frequency.length - 1]) /
                ((double) this.frequency[0] - (double) this.frequency[this.frequency.length - 1]);
        if (a >= 0.6) {
            System.out.println("Color 1");
            return new Color(255, 165, 0);
        } else if (a >= 0.3) {
            System.out.println("Color 2");
            return new Color(255, 140, 0);
        } else if (a >= 0.08) {
            System.out.println(" Color 3");
            return new Color(238, 118, 33);
        } else {
            System.out.println(" Color 4");
            return new Color(139, 69, 19);
        }
    }

    private Color Red ( int frequency){
        double a = ((double) frequency - (double) this.frequency[this.frequency.length - 1]) /
                ((double) this.frequency[0] - (double) this.frequency[this.frequency.length - 1]);
        if (a >= 0.6) {
            System.out.println("Color 1");
            return new Color(255,5,5);
        } else if (a >= 0.2) {
            System.out.println("Color 2");
            return new Color(205,5,5);
        } else if (a >= 0.05) {
            System.out.println(" Color 3");
            return new Color(165,5,5);
        } else {
            System.out.println(" Color 4");
            return new Color(120,4,4);
        }
    }

    private Color Blue ( int frequency){
        double a = ((double) frequency - (double) this.frequency[this.frequency.length - 1]) /
                ((double) this.frequency[0] - (double) this.frequency[this.frequency.length - 1]);
        if (a >= 0.6) {
            System.out.println("Color 1");
            return new Color(55,255,255);
        } else if (a >= 0.3) {
            System.out.println("Color 2");
            return new Color(27,230,230);
        } else if (a >= 0.09) {
            System.out.println(" Color 3");
            return new Color(40,183,188);
        } else {
            System.out.println(" Color 4");
            return new Color(52,133,137);
        }
    }
}



