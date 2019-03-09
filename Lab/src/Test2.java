import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Input s: ");
        double s = sc.nextDouble();
        System.out.printf("Input x0:");
        double x0 = sc.nextDouble();

        if(s < 0){
            System.out.println("Wrong input");
            return;
        }
        if(s == 0){
            System.out.printf("x0 = %.0f", s);
            return;
        }

        if(s - x0*x0 < Math.pow(10, -6) && x0*x0 - s < Math.pow(10, -6))
            System.out.printf("x0 = %.0f\n",x0);
        else
        {
            squareRoot(s, x0);
            double ai, bi, xi, xj;
            xi = x0;
            System.out.printf("x0 = %.0f\n", x0);
            for(int i=1;;i++)
            {

                ai = (s - xi*xi) / (2 * xi);
                bi = xi + ai;
                xj = bi - ai*ai / (2 * bi);
                System.out.printf("x%d = %.6f\n",i,xj);
                if(xj - xi < Math.pow(10, -6) && xi - xj < Math.pow(10, -6)) break;
                xi = xj;
            }
        }
    }

    static void squareRoot(double s, double x0){
        double ai, bi, xi, xj;
        xi = x0;
        System.out.printf("x0 = %.0f\n", x0);
        for(int i=1;;i++)
        {

            ai = (s - xi*xi) / (2 * xi);
            bi = xi + ai;
            xj = bi + (s - bi*bi) / (2 * bi);
            System.out.printf("x%d = %.6f\n",i,xj);
            if(xj - xi < Math.pow(10, -6) && xi - xj < Math.pow(10, -6)) break;
            xi = xj;
            System.out.println("bi*bi-ai*ai = " + (bi*bi-ai*ai));
        }

        System.out.println("*****************Divide Line*******************");
    }
}
