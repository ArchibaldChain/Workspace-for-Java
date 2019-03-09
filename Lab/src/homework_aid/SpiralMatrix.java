package homework_aid;

import java.util.Scanner;

public class SpiralMatrix {

    static Scanner scanner = new Scanner(System.in);
    static int m;
    static int n;

    static int[][] matrix;

    public static void main(String[] args) {
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            m = scanner.nextInt();
            n = scanner.nextInt();
            matrix = new int[m][n];
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = scanner.nextInt();
                }
            }
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            start(x, y);
            System.out.println();
        }


    }

    static void start(int x, int y){
        count = 0;
        System.out.print(matrix[x][y] + " ");
        for (int i = 1; count < m*n - 1; i+=2) {

            /**
            1 2 3 4
            4 5 6 7
            7 8 9 0
            */
            for (int j = y; y < j + i; ) {
                y++;
                rangeCheck(x, y);// move right
            }
            for (int j = x; x < j + i; ) {// move down
                x++;
                rangeCheck(x, y);
            }
            for (int j = y; y > j - i - 1 ; ) {
                y--;
                rangeCheck(x, y);// move left
            }
            for (int j = x; x > j - i - 1 ; ) {
                x--;
                rangeCheck(x, y);// move up
            }


        }

    }

    private static int count;
    static void rangeCheck(int x, int y){
        if(x >= 0 && x < m && y >= 0 && y < n){
            System.out.print(matrix[x][y] + " ");
            count ++;
        }

    }
}
