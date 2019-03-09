package Assignment2;

import java.util.Scanner;

public class Bakhshali {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Input:");
        double s = sc.nextDouble();
        double a, b, x1;
        if(s < 0){
            System.out.println("Wrong input");
            return;
        }
        if(s == 0){
            System.out.printf("x0 = %.0f", s);
            return;
        }
        double x0 = Judge(s);
        a = (s - x0*x0) / (2 * x0);
        b = x0 + a;
        x1 = b - a*a / (2 * b);
        System.out.println("x0 = "+x0);
        System.out.printf("x1 = %.6f", x1);

    }

    static double Judge(double s){
        if(s < 1)
        {
            do
            {
                s = s * 10;
            }while(s < 1);
        }
        if(s - Estimate(s) < 0.000001)
            return s;
        else
            return Estimate(s);
    }

    static int Estimate(double s){
        int i;
        for(i=0; i <= s; i++) {
            if(i*i > s)
                break;

        }
        return i-1;
    }
}


