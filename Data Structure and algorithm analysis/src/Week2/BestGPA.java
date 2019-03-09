package Week2;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class BestGPA {
    static private int[] s;
    static private int[] c;
    static private double maxGPA;
    static private int n, k;


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        n = input.nextInt();
        k = input.nextInt();

        s = new int[n];
        c = new int[n];
        for (int i = 0; i < n; i++)
        {
            s[i] = input.nextInt();
        }
        for (int i = 0; i < n; i++)
        {
            c[i] = input.nextInt();
        }
        binaryDividen(0,1000);
        System.out.printf("%.3f",maxGPA);

    }

    private static void binaryDividen(double a, double b){
        if (Math.abs(a - b) <= 0.00001){
            maxGPA = a;
            return;
        }
        double med = (a+b) / 2, sum = 0;
        //double getNewGPA[] = new double[s.length];
        TreeSet treeSet = new TreeSet();
        for (int i = 0; i < n; i++) {
            //getNewGPA[i] = function(s[i],c[i],med);
            treeSet.add(new Compare(function(s[i],c[i],med)));
        }

        Iterator iterator = treeSet.iterator();

        for (int i = 0; i < n-k && iterator.hasNext(); i++) {
            Compare compare = (Compare)iterator.next();
            sum += compare.getNewGPA();
        }

        if (sum >= 0){
            binaryDividen(med,b);
        } else
            binaryDividen(a, med);
    }


    private static double function(int s, int c, double ans){
        return s*c - ans * s;
    }
}

class Compare implements Comparable {

    private double NewGPA;

    public Compare(double newGPA) {
        NewGPA = newGPA;
    }

    public double getNewGPA() {
        return NewGPA;
    }

    @Override
    public int compareTo(Object obj){
        Compare wf = (Compare)obj;
        if(wf.NewGPA <= this.NewGPA){
            return -1;
        }
        if(wf.NewGPA > this.NewGPA){
            return 1;
        }
        return 0;
    }
}
