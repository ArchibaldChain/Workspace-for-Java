package study_file1;

import java.util.Scanner;

public class Data {
    public static void main(String[] args) {

        double g = 9.7925, Rou0 = 949.4, D = 0.05972, h = 0.3312, PI = 3.141592653;//Constant

        Scanner sc = new Scanner(System.in);
        System.out.println("Input d(mm), vf(m/s), m(g)");
        double d = sc.nextDouble()/1000 , vf = sc.nextDouble(), m = sc.nextDouble() /1000;

        double r = d / 2;
        double Rou = (m/30*3)/(4*PI*r*r*r);


        double n = 2*r*r*g*(Rou - Rou0) / (9*vf*(1+2.4*d/D)*(1+3.3*d/(2*h)));
        System.out.println("n = " + n);
        double Re = 2*vf*Rou0* r/n;
        System.out.println("Re = " + Re);
    }
}
