package Week2;

import java.util.Scanner;

public class Demon {
    static int quan;

    public static void main(String[] args) {

        int number;// the number of the test cases
        Scanner input = new Scanner(System.in);
        number = input.nextInt();
        int n;
        long m;
        for (int i = 0; i < number; i++)
        {
            quan = 0;
            n = input.nextInt();
            m = input.nextInt();
            long[] a = new long[n];
            for (int j = 0; j < n; j++)
            {
                a[j] = input.nextInt();
            }
            compare(a, m);
            System.out.println(quan);
        }
    }
    static private void compare(long[] a, long m){
        for (int i = 0; i < a.length - 1; i++) {
            if(a[i] == 0){
                continue;
            }
            for (int j = i+1; j < a.length; j++) {
                if(a[j] == 0){
                    continue;
                }
                if(a[i]+a[j] == m){
                    a[j] = 0;
                    quan ++;
                }
                if (a[i]+a[j] >= m)
                    break;
            }
        }
    }
}
