package Notes;

import java.util.Scanner;

/**
 * ProjectName:    Test 2
 * Author:         Archibald Chain
 * CreateDate:     2019/4/18 23:39
 * Version:        1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class PrimeFactorization {
    public static void main(String[] args) {
        int n = 561;
//        for (int i = 1; i < 13; i++) {
//           n *= i;
//        }
        int prime = 2;
        while (prime <= n){
            if (n % prime == 0)
                System.out.println(prime);
            prime = FindSuNumber.findNextSuNumber(prime);
        }
    }

}
