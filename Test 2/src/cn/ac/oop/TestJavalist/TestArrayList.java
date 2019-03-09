package cn.ac.oop.TestJavalist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class TestArrayList {
    public static void main(String[] args) {
        Integer[] array = new Integer[8];
        ArrayList<Integer> al = new ArrayList<>();
//       Collections.addAll(al, array);
        System.out.println("Input a Arraylist: ");
        Scanner sc = new Scanner(System.in);

        for(int i=0;i<4;i++)
            al.add(sc.nextInt());

        System.out.println("size "+al.size());  //ArrayList.size()
        System.out.println("al: "+al.toString());  //ArrayList.toString()
        while(true){
            int RaNum =  RandomNumber(-5,5);
            System.out.printf("The number is %d: ",RaNum);
            if(RaNum == 0) break;
            switch(RaNum){
                case(1): {
                    for(int i = 0; i < al.size(); i++)
                    {
                        if(al.get(i) > 0)
                        {
                            al.remove(i);
                            i--;
                        }
                    }
                    System.out.println(al.toString());break;
                }
                case(-1):{
                    for(int i = 0; i < al.size(); i++)
                    {
                        if(al.get(i) < 0)
                        {
                            al.remove(i);
                            i--;
                        }
                    }
                    System.out.println(al.toString());break;
                }

                case(5): Collections.sort(al);System.out.println(al.toString());break;
                case(-5):System.out.println("size "+al.size());System.out.println(al.toString());break;
                default: al.add(RaNum);System.out.println(al.toString());break;

            }


        }
    }

    static int RandomNumber(int down_bound, int up_bound){
//        Random rand = new Random();
//
//        if(rand.nextInt() < 0)
//            return rand.nextInt()%5;
//        else return rand.nextInt()%5 + 1;
        return (int)(Math.random()*(up_bound - down_bound)-up_bound);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}