package homework_aid;

import java.math.BigInteger;
import java.util.Scanner;

public class PascalTriangle {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt() - 1;
            for (int j = 0; j <= n; j++) {
                System.out.print(combination(j, n).toString());
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static BigInteger combination(int x, int n){
        if (n == 0 || n == 1)
            return new BigInteger("1");
        else {
            return factorial(n).divide(
                    factorial(x).multiply(factorial(n - x)));
        }
    }


    private static BigInteger factorial(int n){
        if (n == 0)
            return new BigInteger( "1");
        BigInteger bigInteger = new BigInteger("1");
        for (int i = 0; i < n; i++) {
            int temp = i+1;
            bigInteger = bigInteger.multiply(new BigInteger(temp + ""));
        }
        return bigInteger;
    }

}
