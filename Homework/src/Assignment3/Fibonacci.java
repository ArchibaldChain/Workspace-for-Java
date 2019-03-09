package Assignment3;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Long[] Limit = new Long[n];
        for(int i = 0; i < n; i++)
        {
            Limit[i] = sc.nextLong();
        }
        for (int z=0; z < n; z++)
        {
            Long i=1l;
            if (i > Limit[z]) continue;
            System.out.println(i);
            Long j=2l;
            if (j > Limit[z]) continue;
            System.out.println(j);
            Long k = i+j;
            if (k > Limit[z]) continue;
            for(;;)
            {
                k = i+j;
                if(k > Limit[z]) break;
                System.out.println(k);
                i = j;
                j = k;
            }
        }

    }
}