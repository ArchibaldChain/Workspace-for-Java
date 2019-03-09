package Week2;

import java.util.Scanner;
import static java.lang.Math.*;


public class RubertyRite {

    static private double[] x;
    static private double[] w;
    static private double minDistance = 0;

    public static void main(String[] args) {
        int number;// the number of the test cases
        Scanner input = new Scanner(System.in);
        number = input.nextInt();

        for (int j = 0; j < number; j++) {
            int n = input.nextInt();

            x = new double[n];
            w = new double[n];
            for (int i = 0; i < n; i++)
            {
                x[i] = input.nextDouble();
                //System.out.print("x = " + x[i]);
                w[i] = input.nextDouble();
                //System.out.println(", w = " + w[i]);
            }
            //三分查找
            ternaryDivide(x[0],x[x.length-1]);
            System.out.printf("Case #%d: %.0f\n",j+1, minDistance);
        }

    }

    private static void ternaryDivide(double a, double b){
        if (abs(a - b) <= 0.0000000000001){
            minDistance = sigma(a);
            return;
        }
        //System.out.println("a = [" + a + "], b = [" + b + "]");
        double mid = (a+b)/2d;
        double midmid = (mid + b)/2d;
        double fmid = sigma(mid), fmidmid = sigma(midmid);
        if (fmid <= fmidmid){
            ternaryDivide(a,midmid);
        }

        else{
            ternaryDivide(mid,b);
        }

    }
    private static double sigma(double position){
        double sigma = 0;
        for (int i = 0; i < x.length; i++) {
            sigma += w[i]*pow(abs(x[i]-position),3);
            //System.out.println("w[i]*pow(abs(x[i]-position),3) = [" + w[i]*pow(abs(x[i]-position),3) + "]");
            
        }
        //System.out.println("sigma = " + sigma);
        return sigma;
    }
}
/*

 3
 4
 0.6 5
 3.9 10
 5.1 7
 8.4 10
 4
 0.6 5
 3.9 10
 5.1 7
 8.4 10
 6
 3 65
 5 7
 787 86
 5456 7
 56784 4564
 85643 56

 */