package Week8;

import java.util.Arrays;
import java.util.Scanner;

public class Leaves {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number, n;
        n = scanner.nextInt();

        for (int i = 0; i < n; ++i) {
            number = scanner.nextInt();
            int a[] = new int[number + 1];
            for (int j = 0; j < number - 1; ++j) {
                int c, b;
                c = scanner.nextInt();
                b = scanner.nextInt();
                a[c]++;
            }
            int leaves[] = new int[number];
            for (int j = 1; j <= number; ++j) {
                if(a[j] == 0)
                    leaves[j-1] = j;
            }
            Arrays.sort(leaves);
            for (int j = 0; j < number; j++) {
                if(leaves[j] != 0)
                    System.out.print(leaves[j] +" ");
            }
            System.out.printf("\n");
        }

    }
}
