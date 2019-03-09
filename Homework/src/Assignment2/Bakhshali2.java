package Assignment2;

import java.util.Scanner;

public class Bakhshali2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Input: ");
        double s = sc.nextDouble();
       EstimateProcess(s);
    }

    static void EstimateProcess(double s){

        if(s < 0){
            System.out.println("Wrong input");
            return;
        }
        if(s == 0){
            System.out.printf("x0 = %.0f", s);
            return;
        }
        double x0 = Bakhshali.Judge(s);

        if(s - x0*x0 < Math.pow(10, -6) && x0*x0 - s < Math.pow(10, -6))
            System.out.printf("x0 = %.0f\n",x0);
        else
        {
            double ai, bi, xi, xj;
            xi = x0;
            System.out.printf("x0 = %.0f\n", x0);
            for(int i=1;;i++)
            {

                ai = (s - xi*xi) / (2 * xi);
                bi = xi + ai;
                xj = bi - (ai*ai) / (2 * bi);
                System.out.printf("x%d = %.6f\n",i,xj);
                if(xj - xi < Math.pow(10, -6) && xi - xj < Math.pow(10, -6)) break;
                xi = xj;
            }
        }

        System.out.printf("Library: %.6f",Math.sqrt(s));

    }
}

