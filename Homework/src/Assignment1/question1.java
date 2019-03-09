package Assignment1;

import java.util.Scanner;

public class question1
{
    public static void main(String[] args)
    {
        double v0, g = 9.8, t1 = 1, u = 0.7;
        double x1, x2;
        Scanner input = new Scanner(System.in);
        System.out.println("Input the speed: ");
        v0 = input.nextDouble();
        double v = v0 / 3.6;
        x1 = v * t1;
        x2 = v * v / 2 / u / g;
        System.out.printf("<speed in %.2fkm/h> <b.d.=%.2fm on wet road> <b.d=%.2fm on dry road>",
                v, x1+x2, x1+1.5*x2);
    }
}
