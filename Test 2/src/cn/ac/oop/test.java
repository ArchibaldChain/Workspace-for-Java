package cn.ac.oop;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String words[] = new String[3];
        for (int j = 0; j < 3; j++) {
            words[j] = input.nextLine().toLowerCase();
            //input.nextLine();
            //System.out.println(words[j]);
        }
        input.nextInt();
    }
}
