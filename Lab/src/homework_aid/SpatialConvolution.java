package homework_aid;

import java.util.Scanner;

public class SpatialConvolution {

    static double[][] h;
    static int[][] x;
    static int H,W;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            System.out.println("i = " + i);
            int m = scanner.nextInt();
            h = new double[m][m];
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    h[j][k] = scanner.nextDouble();
                }
            }
            H = scanner.nextInt();
            W = scanner.nextInt();
            x = new int[H][W];
            for (int j = 0; j < H; j++) {
                for (int k = 0; k < W; k++) {
                    x[j][k] = scanner.nextInt();
                }
            }
            calculate();

        }
    }

    static private void calculate(){
        System.out.println("SpatialConvolution.calculate");
        for (int i = 0; i < H; i++) {

            for (int j = 0; j < W; j++) {

                double num = 0;
                for (int u = 0; u < h.length; u++) {
                    for (int v = 0; v < h.length; v++) {
                            num += h[u][v] * getX(i - u + h.length/2,j - v + h.length/2 );
                    }
                }
                long a = Math.round(num);
                if (a < 0)
                    a = 0;
                if (a > 255)
                    a = 255;
                System.out.printf("%3d", a);
            }
            System.out.println();
        }
    }

    public static int getX(int x, int y){
        int[][] pix = SpatialConvolution.x;
        if (x >= 0 && x < H && y >= 0 && y < W)
            return pix[x][y];
        if (x < 0)
            x = 0;
        if (x >= H)
            x = H - 1;
        if (y < 0)
            y = 0;
        if (y >= W)
            y = W - 1;
        return pix[x][y];
    }
}
