package Week1;

import java.math.BigInteger;
import java.util.Scanner;

public class HannoiTower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;
        number = scanner.nextInt();
        for(int i = 0; i < number; i++)
        {
            int n;
            n = scanner.nextInt();
            BigInteger a = BigInteger.valueOf(3);
            BigInteger b = BigInteger.valueOf(1000000007);
            BigInteger c = BigInteger.valueOf(1);
            BigInteger e = c;
            for(int j=0; j<n; j++){
                c = c.multiply(a);
            }
            c = c.subtract(e);
            c = c.mod(b);
            System.out.println(c);
        }
    }
}
