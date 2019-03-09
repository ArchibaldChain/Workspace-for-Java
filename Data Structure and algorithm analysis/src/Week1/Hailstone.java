package Week1;

import java.util.LinkedList;

public class Hailstone {

    static LinkedList linkedList;

    public static void main(String[] args) {
        linkedList = new LinkedList();
        hailsotne(12, linkedList);
    }

    public static void hailsotne(int n, LinkedList<Integer> linkedList){
        linkedList.add(n);
        if(n == 1)
            return;
        else if (n%2==0)
            hailsotne(n/2, linkedList);
        else if (n %2!=0)
            hailsotne(3*n+1, linkedList);

    }
}
