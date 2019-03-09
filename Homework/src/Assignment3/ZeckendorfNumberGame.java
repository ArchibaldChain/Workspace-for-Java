package Assignment3;

import java.util.Scanner;

public class ZeckendorfNumberGame {
    private static int fibonacci[] = {1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int number[] = new int[n];

        for (int i = 0; i < n; i++)
            number[i] = sc.nextInt();

        for (int i = 0; i < n; i++)
        {
            if(number[i] < 1 ||  number[i] > 100){
                System.out.println("Invalid Number");
                continue;
            }
            ZeckendorfTherom(number[i]);
            System.out.println();
        }

    }

    private static void ZeckendorfTherom(int x){
        int fn = search(x);
        if (x == fn)
        {
            System.out.print(x);
            System.out.print(" ");
            return;
        }

        ZeckendorfTherom(x - fn);
        System.out.print(fn);
        System.out.print(" ");
    }

    private static int search(int x){
        for(int i = 0; i < 11 ; i++){
            if(fibonacci[i] > x)
                return fibonacci[i-1];
        }
        return 0;
    }
}
