package study_file1;

import java.util.ArrayList;
import java.util.Scanner;

public class Pizza {
    private int size = 10;
    private String[] kinds = {"Seafood", "Mushroom", "Beef ","Cheese"};
    private String kind = kinds[1];
    private double Price = 150;

    public void setSize(int size) {
        if(size < 0 && size > 1000) return;
        this.size = size;
    }

    public void setKind(int i) {
        this.kind = this.kinds[i-2];
    }

    public void setPrice(double price) {
        Price = price;
    }

    @Override
    public String toString() {
        return "Pizza [name="+kind+", size="+size+", price="+ Price+']';
    }
}

class Main{
    public static void main(String[] args) {

        ArrayList<Pizza> al = new ArrayList<Pizza>();
        Scanner sc = new Scanner(System.in);
        int i = -1;
        while (true){

            int a = sc.nextInt();

            if (a < 0 || a > 5) {
                System.out.println("Input again");
                continue;
            }
            if (a == 0) break;

            if (a == 1)
            {
                if (i == -1) {
                    System.out.println("Input again");
                }
                for (int j = 0; j <= i; j++)
                {
                    System.out.println(al.get(j).toString());
                }
                continue;
            }
            i++;
            al.add(new Pizza());
            al.get(i).setKind(a);
            System.out.print("Input the size:");
            al.get(i).setSize(sc.nextInt());
            System.out.print("Input the price:");
            al.get(i).setPrice(sc.nextDouble());

        }
    }
}
