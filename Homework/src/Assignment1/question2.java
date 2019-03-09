package Assignment1;

import java.util.Scanner;

public class question2
{
    public static void main(String[] args)
    {
        double g = 9.8, t1 = 1, u = 0.7;
        double x1, x2;
        Scanner input = new Scanner(System.in);
        System.out.println("Input the start speed: ");
        int v0 = input.nextInt();
        System.out.println("Input the top speed: ");
        int v1 = input.nextInt();
        v0 = v0 - (v0%5);
        v1 = v1 + 5 - (v1%5);
        for(int i = v0; i <= v1; i += 5)
        {
            double v = i / 3.6;
            x1 = v * t1;
            x2 = v * v / 2 / u / g;
            System.out.printf("<speed in %dkm/h> <b.d.=%.2fm on wet road> <b.d=%.2fm on dry road>\n"
                    , i, x1+x2, x1+1.5*x2);
        }
    }

}
