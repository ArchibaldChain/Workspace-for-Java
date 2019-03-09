package cn.ac.oop.testDate;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;

public class testDate {
    public static void main(String[] args) {
        System.out.println("testDate.main");
        Date d = new Date(1000);
        Date d1 = new Date();
        long t = System.currentTimeMillis();
        System.out.println("t = [" + t + "]");

        System.out.println("d = " + d.toGMTString());
        System.out.println("d1 = " + d1);

    }
}
