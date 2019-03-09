package Week12;

import java.util.Arrays;

import static java.lang.Math.random;

/**
 * @ProjectName: Data Structure and algorithm analysis
 * @Author: Archibald Chain
 * @CreateDate: 2018/11/24 11:33
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class Line {

    public static void main(String[] args) {

        int n = 300;
        int a, b, c;
        Heap heap = new Heap();
        int timeKeeper = 0;
        int deletedNumber = 0;
        for (int i = 0; i < n; i++) {

            if (i % 3 == 0){
                a = (int)(random() * 10 + 1);
                heap.add(a);
                System.out.println("add a customer who will spend "+a+" seconds");
                System.out.println();
            }

            //trouble maker
            if (i % 5 == 0){
                b = (int)(random() * heap.getSize() + 1);
                c = (int)(random() * 10 + 1);
                System.out.println("The No."+ b+" customer changed time to "+ c);
                heap.levelOrderOutPut();
                heap.changeNode(b, c);
                heap.levelOrderOutPut();
                System.out.println();
            }


            if (i >= timeKeeper){

                deletedNumber++;

                a = heap.delete();
                System.out.println("The customer whose time costs " + a+ "s is in the processing");
                timeKeeper += a;
                System.out.println("Next customer will be handled with at "+ (timeKeeper+1) + "s");
                System.out.println();
            }
        }
    }

}

class Heap {

    private Node[] heap;
    private int size;

    public Heap(){
        heap = new Node[16];
        size = 0;
    }

    public Heap(int value) {
        new Heap();
        add(value);
    }

    public int getSize() {
        return size;
    }

    public void add(int x){

        rangeCheck();
        heap[size] = new Node(x);

        size++;
        moveForward(size - 1);
    }

    private void moveForward(int n){
        int father, son = n;
        while(son > 0){
            father = (son-1)/2;
            if (heap[father].compareTo(heap[son]) ){
                exchange(father, son);
            }
            son = father;
        }
    }

    public int delete(){
        if (size == 0){
            System.out.println("Line empty");
            return 0;
        }
        Node temp = heap[0];
        heap[0] = heap[size - 1];

        heap[size - 1] = null;
        size --;
        if(size < heap.length/2)
            heap = Arrays.copyOf(heap, heap.length/2);

        moveBack(0);
        System.out.println(temp.getName() + " is deleted.");
        return temp.getValue();
    }
    private void moveBack(int n){
        int father = n;
        int leftSon = n*2 + 1, rightSon = 2*n + 2;
        System.out.println(n);
        while (leftSon < size){
            Node temp = Node.min(heap[leftSon],
                    heap[rightSon]);
            if (temp == null)
                break;
            else if (heap[father].compareTo( temp) ){
                if (heap[leftSon] == temp ){
                    exchange(father, leftSon);
                    father = leftSon;
                }
                else if (heap[rightSon] == temp){
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



    public void changeNode(int number, int newValue){

        for (int i = 0; i < size; i++) {
            if (heap[i].number == number){

                if (newValue > heap[i].value){
                    heap[i].value = newValue;
                    moveBack(i);
                } else if (newValue < heap[i].value){
                    heap[i].value = newValue;
                    moveForward(i);
                }
                return;
            }
        }
        System.out.println("Not Found");
    }

    public void levelOrderOutPut(){
        for (int i = 0; i < size; i++) {
            print(i);
        }
        System.out.println();
    }

    private void print(int i){
        System.out.print(heap[i].name+ ":" +heap[i].value + " ");
    }

    private void rangeCheck(){
        if (size >= heap.length)
            heap = Arrays.copyOf(heap,2*size + 2);
    }

    private void exchange(int a, int b){
        Node temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    static class Node {
        static int Number = 0;
        private int number;
        private int value;
        String name;
        private int getValue() {
            return value;
        }

        private String getName() {
            return name;
        }

        Node(int value) {
            this.value = value;
            number = ++Number;
            name = "No." + number;
        }

        boolean compareTo(Node n){
            return (this.value > n.value);
        }

        static Node min (Node a, Node b){
            if (b == null && a != null)
                return a;
            else if (a == null && b != null)
                return b;
            else if (a == null)
                return null;

            if (a.value < b.value)
                return a;
            else return b;
        }
    }
}