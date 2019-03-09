package Week2;

import java.util.Scanner;
import static java.lang.Math.*;


public class HighSchoolProblem {

    private static long Y;
    private static double minmum = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;
        number = scanner.nextInt();
        for (int i = 0; i < number; i++) {
            Y = scanner.nextLong();
            if (derivativeFunction(100) <= 0)
                System.out.printf("Case %d: %.4f\n",i+1,function(100));

            else {
                binaryDivide(0,100);
                System.out.printf("Case %d: %.4f\n",i+1,minmum);
            }
        }
    }

    private static void binaryDivide(double a, double b){

        if(abs(function(a) - function(b)) <= 0.00001){
            minmum = function((a+b)/2f);
            return;
        }

        double c = (a+b)/2f;
        double derOfC = derivativeFunction(c);

        if (derOfC > 0){
            binaryDivide(a,c);
        } else if (derOfC < 0){
            binaryDivide(c,b);
        }
            
        else
        {
            minmum = function(a);
        }
    }

    private static double function(double x){
        return 5*pow(x,7) + 6*pow(x,6)+ 3*pow(x,3)+4*pow(x,2)-2*x*Y;
    }

    private static double derivativeFunction(double x){
        return 35*pow(x,6) + 36*pow(x,5)+ 9*pow(x,2)+8*x-2*Y;
    }
}