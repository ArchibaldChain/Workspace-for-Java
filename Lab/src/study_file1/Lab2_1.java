package study_file1;

import java.util.Scanner;

public class Lab2_1 {   //Minutes --- Years day
    public static void main(String[] args)
    {
        double minute;
        Scanner input = new Scanner(System.in);
        System.out.println("Please input a number of minutes:");
        minute = input.nextDouble();
        int day, year;
        day = (int)(minute / 60 / 24);
        year = day / 365;
        day = day % 365;
        System.out.println("It equals "+year+"years and"+day+"days\n");

    }
}
