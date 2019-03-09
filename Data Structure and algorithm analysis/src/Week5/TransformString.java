package Week5;

import java.util.Scanner;

public class TransformString {


    /**
     *  ^  >   * /  > +-
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String equation = scanner.nextLine();
        char[] a = equation.toCharArray();
        int[] b = new int[a.length];
        for (int i = 0; i < b.length; i++) {
            if(a[i] == '+' || a[i] == '-')
                b[i] = 0;
            else if (a[i] == '*' || a[i] == '/')
                b[i] = 1;
            else if (a[i] == '^')
                b[i] = 3;
            else if (a[i] == '(' || a[i] == ')')
                b[i] = -1;
            else
                b[i] =  4;
        }

        Stack stack = new Stack();

        for (int i = 0; i < b.length; i++) {

            if (b[i] == 4){
                System.out.print(a[i]);
                continue;
            }
            if (stack.isEmpty()){
                stack.push(i);
                continue;
            }

            if (a[i] == ')'){
                while (a[(Integer)stack.getTop()] != '('){
                    System.out.print( a[(Integer)stack.pop()]);

                    if (stack.isEmpty())
                        break;
                }
                stack.pop();
                continue;
            }
            while (b[i] <= b[(Integer)stack.getTop()] && a[i] != '('){
                System.out.print( a[(Integer)stack.pop()]);

                if (stack.isEmpty())
                    break;
            }
            stack.push(i);

        }
        while (!stack.isEmpty()){
            System.out.print( a[(Integer)stack.pop()]);
        }
    }
}

class Stack{

    private Node top;

    public Stack(Object obj) {
        top = new Node(obj);
    }

    public Stack() {
    }

    public void push(Object obj){

        if(top == null){
            top = new Node(obj);
            return;
        }
        Node temp = top;
        top = new Node(obj, temp);
    }

    public Object getTop() {
        return top.getObj();
    }

    public Object pop(){
        Object get = getTop();
        top = top.getNextNode();
        return get;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public void makeEmpty(){
        top = null;
    }
}

class Node{
    private Object obj;
    private Node nextNode;

    Node(Object obj) {
        this.obj = obj;
    }

    Node(Object obj, Node nextNode) {
        this.obj = obj;
        this.nextNode = nextNode;
    }

    Object getObj() {
        return obj;
    }

    Node getNextNode() {
        return nextNode;
    }
}