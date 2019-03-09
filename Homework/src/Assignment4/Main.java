package Assignment4;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String d = null;
        String[] a = {"hello","", "world",""},b = {null,"","agfsdg","vcvs"};
        //Entropy.main(a);
        int c[][] = Entropy.charCountArray(b);
        for (int i = 0; i < c.length; i++) {
            System.out.println(Arrays.toString(Entropy.charCountArray(b)[i]));
        }

    }

}
