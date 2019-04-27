package DemoPackage;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ProjectName:    Test 2
 * Author:         Archibald Chain
 * CreateDate:     2019/3/29 14:25
 * Version:        1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class Archibald {
    public static void main(String[] args) {


        double[] num = new double[3];//
        char[] cal = new char[2];//
        int nums = 0;
        int cals = 0;
        Scanner in  = new Scanner(System.in);
        in.nextInt();

        String ss = "33*ddf(d5 \\^ 7 fs-";
        System.out.println(ss);
        String[]strings = ss.split("\\|");
        System.out.println(Arrays.toString(strings));
    }
    public static void a(){
        System.out.println("Archibald.a");
    }
}
