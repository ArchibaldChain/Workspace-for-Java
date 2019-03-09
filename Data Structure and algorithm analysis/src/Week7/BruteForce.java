package Week7;

import java.sql.SQLOutput;
import java.util.Scanner;

public class BruteForce {
    public static void BruteForce(String text, String pattern) {

        char[] txt = text.toCharArray();
        char[] pat = pattern.toCharArray();
        boolean find = true;
        for (int i = 0; i < txt.length - pat.length + 1; i++) {
            find = true;
            for (int j = 0; j < pat.length; j++) {

                if (txt[i+j] != pat[j]){
                    find = false;
                    break;
                }
            }
            if (find)
                System.out.println("The string at: "+i+" is the first of the found place");
        }
    }
}
