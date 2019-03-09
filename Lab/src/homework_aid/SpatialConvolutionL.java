package homework_aid;

import java.util.*;

public class SpatialConvolutionL {

    public static void displayMatrix(int[][] matrix, int H, int W) {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                System.out.printf("%3d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void corner(int[][] image, int i, int j, int M, int x) {
        for (int k = i; k < i + (M + 1) / 2; k++) {
            for (int l = j; l < j + (M + 1) / 2; l++) {
                image[k][l] = x;
                //System.out.printf("%d(%d, %d) ", image[k][l], k, l);
            }
            //System.out.println();
        }
    }

    public static void column(int[][] image, int i, int j, int M, int x) {
        for (int k = 0; k < (M + 1) / 2; k++) {
            image[i + k][j] = x;
        }
    }

    public static void row(int[][] image, int i, int j, int M, int x) {
        for (int k = 0; k < (M + 1) / 2; k++) {
            image[i][j + k] = x;
        }
    }

    public static double convolution(double[][] kernel, int[][] image, int i, int j, int M) {
        double sum = 0;
        //System.out.printf("Start from %d(%d, %d) ", image[i - (M - 1) / 2][j - (M - 1) / 2], i - (M - 1) / 2, j - (M - 1) / 2);
        //System.out.printf("Center %d(%d, %d)\n", image[i][j], i, j);
        for (int k = 0; k < M; k++) {
            for (int l = 0; l < M; l++) {
                sum += kernel[k][l] * image[i - (M - 1) / 2 + k][j - (M - 1) / 2 + l];
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int M = in.nextInt();

            double kernel[][] = new double[M][M];
            int coef = 0;
            for (int j = M - 1; j >= 0; j--) {
                for (int k = M - 1; k >= 0; k--) {
                    kernel[j][k] = in.nextDouble();
                    coef += kernel[j][k];
                }
            }
            if (coef == 0)
                coef = 1;
            /*
            System.out.println("Coefficient = " + coef);
            System.out.println("Kernel:");
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < M; k++) {
                    System.out.print(kernel[j][k] + " ");
                }
                System.out.println();
            }
            */
            int H = in.nextInt();
            int W = in.nextInt();
            //System.out.println("H = " + H + ", W = " + W);
            //System.out.printf("Expanded H = %d, W = %d\n", H + M - 1, W + M - 1);
            int image[][] = new int[H + M - 1][W + M - 1];
            int blurredImage[][] = new int[H][W];
            for (int j = (M + 1) / 2 - 1; j < H + (M - 1) / 2; j++) {
                for (int k = (M + 1) / 2 - 1; k < W + (M - 1) / 2; k++) {
                    image[j][k] = in.nextInt();
                }
            }

            //System.out.printf("left up %d(%d, %d)\n", image[(M + 1) / 2 - 1][(M + 1) / 2 - 1], 0, 0);
            corner(image, 0, 0, M, image[(M + 1) / 2 - 1][(M + 1) / 2 - 1]);
            //System.out.printf("left down %d(%d, %d)\n", image[H + (M - 1) / 2 - 1][(M + 1) / 2 - 1], H + (M - 1) / 2 - 1, 0);
            corner(image, H + (M - 1) / 2 - 1, 0, M, image[H + (M - 1) / 2 - 1][(M + 1) / 2 - 1]);
            //System.out.printf("right up %d(%d, %d)\n", image[(M + 1) / 2 - 1][W + (M - 1) / 2 - 1], 0, W + (M - 1) / 2 - 1);
            corner(image, 0, W + (M - 1) / 2 - 1, M, image[(M + 1) / 2 - 1][W + (M - 1) / 2 - 1]);
            //System.out.printf("right down %d(%d, %d)\n", image[H + (M - 1) / 2 - 1][W + (M - 1) / 2 - 1], H + (M - 1) / 2 - 1, W + (M - 1) / 2 - 1);
            corner(image, H + (M - 1) / 2 - 1, W + (M - 1) / 2 - 1, M, image[H + (M - 1) / 2 - 1][W + (M - 1) / 2 - 1]);

            for (int j = (M + 1) / 2; j < (M + 1) / 2 + H - 2; j++) {
                column(image, 0, j, M, image[(M + 1) / 2 - 1][j]);
                column(image, H + (M - 1) / 2 - 1, j, M, image[H + (M - 1) / 2 - 1][j]);
            }

            for (int j = (M + 1) / 2; j < (M + 1) / 2 + H - 2; j++) {
                row(image, j, 0, M, image[j][(M + 1) / 2 - 1]);
                row(image, j, W + (M - 1) / 2 - 1, M, image[j][W + (M - 1) / 2 - 1]);
            }

            for (int j = 0; j < H; j++) {
                for (int k = 0; k < W; k++) {
                    double temp = coef * convolution(kernel, image, j + (M + 1) / 2 - 1, k + (M + 1) / 2 - 1, M);
                    if (temp < 0)
                        blurredImage[j][k] = 0;
                    else if (temp > 255)
                        blurredImage[j][k] = 255;
                    else
                        blurredImage[j][k] = (int) Math.round(temp);
                }
            }

            displayMatrix(blurredImage, H, W);
        }
        in.close();
    }
}
