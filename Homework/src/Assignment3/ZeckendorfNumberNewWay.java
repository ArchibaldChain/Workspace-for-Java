package Assignment3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ZeckendorfNumberNewWay {
    private static int fibonacci[] = {1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144};

    public static void main (String[]args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int number[] = new int[n];

        for (int i = 0; i < n; i++)
            number[i] = sc.nextInt();

        for (int i = 0; i < n; i++)
        {

            if (number[i] < 1 || number[i] > 100) {
                System.out.println("Invalid");
                continue;
            }
            findCards(number[i]);
        }
    }

    private static void ZeckendorfMethod(int x,int x0, ArrayList<List> al){
        int fn = search(x);
        if (x == fn)
        {
            al.get(findTheIndexOfCard(fn)).add(x0);
            return;
        }

        ZeckendorfMethod(x - fn,x0,al);
        al.get(findTheIndexOfCard(fn)).add(x0);
    }

    private static int search(int x){
        for(int i = 0; i < 11 ; i++){
            if(fibonacci[i] > x)
                return fibonacci[i-1];
        }
        return 0;
    }

    private static void findCards(int number) {

        int n = findTheIndexOfCard(search(number));
        ArrayList<List> al = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            al.add(new ArrayList<String>());
        }

        for (int j = 1; j <= number; j++)  //This is the beginning.Give any number from 1 to n
        {
            ZeckendorfMethod(j,j,al);
        }

        for (int j = 0; j <= n; j++)
        {
            System.out.print("Card #"+(j+1)+":");
            for (Object k : al.get(j)) {
                System.out.print(k);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static int findTheIndexOfCard(int Fibonacci) {
        for (int l = 0; l < 11; l++) {
            if (Fibonacci == fibonacci[l]) {
                return l;
            }
        }
        return 0;
    }
}