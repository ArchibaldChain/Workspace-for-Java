package Week1;

import java.util.Scanner;

public class Problem1{

    static String words[];
    static String Sentence[];
    static boolean contains;

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int num_case = input.nextInt();
        int numberGiven,lengthOfSentences;
        for (int i = 0; i < num_case; i++) {
            contains = false;
            numberGiven = input.nextInt();
            words = new String[numberGiven];
            input.nextLine();
            for (int j = 0; j < numberGiven; j++) {
                words[j] = input.nextLine().toLowerCase();
            }

            lengthOfSentences = input.nextInt();
            input.nextLine();
            Sentence = input.nextLine().toLowerCase().split(" ");

            for (int j = 0; j < lengthOfSentences; j++) {

                for (int k = 0; k < words.length; k++) {
                    if(words[k].equals(Sentence[j])){
                        System.out.println("Appeared");
                        contains = true;
                        break;
                    }
                }
                if (contains)
                    break;
            }
            if(!contains)
                System.out.println("Not appeared");
        }
    }
}