package Week7;

import java.util.Date;
import java.util.Scanner;

public class StringSearching {
    public static void main(String[] args) {
        Date date1, date2;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the Text:");
        String text = scanner.nextLine();
        System.out.println("Please input the Pattern:");
        String pattern = scanner.nextLine();
        date1 = new Date(System.currentTimeMillis());
        BruteForce.BruteForce(text, pattern);
        date2 = new Date(System.currentTimeMillis());
        outPutTimeDifference(date1.getTime(), date2.getTime());

        date1 = new Date(System.currentTimeMillis());
        KMPalgorithm.KMPimplement(text, pattern);
        date2 = new Date(System.currentTimeMillis());
        outPutTimeDifference(date1.getTime(), date2.getTime());
    }

    private static void outPutTimeDifference(long a, long b){
        System.out.println("The time used was:"+(b - a)+" ms");
    }

}
