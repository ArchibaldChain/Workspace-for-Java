package Week9;


import java.io.*;

import java.util.*;

public class Heap {
    static PrintWriter out;
    static InputReader in;

    private static int[] heap;
    private static int size;

    public static void main(String[] args) {
        out = new PrintWriter(System.out);
        try {
            in = new InputReader(System.in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int t = in.nextInt();
        //PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

        for (int i = 0; i < t; i++) {
            int n = in.nextInt();

            heap = new int[n];
            size = 0;

            for (int j = 0; j < n; j++) {
                add(in.nextInt());
                for (int k = 0; k < heap.length; k++) {
                    System.out.print(heap[k]+ " ");
                }
                System.out.println();
            }

            int q = in.nextInt();
            for(int j = 0; j < q; j++) {
                int operation = in.nextInt();
                switch (operation){
                    case 1: add(in.nextInt()); break;
                    case 2: delete(); break;
                    case 3: print(); break;
                }

            }
        }
    }

    private static void add(int x){

        rangeCheck();
        heap[size] = x;
        size++;
        int father, son = size - 1;
        while(son > 0){
                father = (son-1)/2;
            if (heap[father] > heap[son]){
                exchange(father, son);
            }

            son = father;
        }
    }


    private static void delete(){
        heap[0] = heap[size - 1];
        heap[size - 1] = 0;
        size --;
        if(size < heap.length/2)
            heap = Arrays.copyOf(heap, heap.length/2);

        int leftSon = 1, rightSon = 2, father = 0;

        while (leftSon < size){
            if (heap[father] > Math.min(heap[leftSon],heap[rightSon])){
                if (heap[leftSon] < heap[rightSon]){
                    exchange(father, leftSon);
                    father = leftSon;
                } else{
                    exchange(father ,rightSon);
                    father = rightSon;
                }
            } else {
                break;
            }
            leftSon = father*2 + 1;
            rightSon = father*2 + 2;
        }
    }

    private static void print(){
        System.out.println(heap[0]+ " ");
    }

    private static void rangeCheck(){
        if (size >= heap.length)
            heap = Arrays.copyOf(heap,2*size + 2);
    }

    private static void exchange(int a, int b){
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }
}


