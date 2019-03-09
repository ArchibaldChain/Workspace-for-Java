package cn.ac.oop.Collection;

import cn.ac.oop.testInterface.MyInterface;

public class MyLinkedList {
    private Node first;
    private Node last;

    private int size;

    public void add (Object obj){
        if (first == null ){
            Node n = new Node(obj);
            n.setPrevious(null);
            n.setNext(null);

            first = n;
            last = n;
        } else {
            Node n = new Node(obj);
            n.setPrevious(last);
            n.setNext(null);
            last.setNext(n);

            last = n;
        }
        size ++;
    }

    public void insertAt(int index, Object obj){
        rangeCheck(index - 1);
        if (index == size){
            add(obj);
        } else {
            Node temp = node(index);
            Node pre = temp.getPrevious();
            Node newNode = new Node(obj);

            pre.setNext(newNode);
            newNode.setPrevious(pre);
            newNode.setNext(temp);
            temp.setPrevious(newNode);

        }
        size ++;
    }


    public Object get(int index){
        rangeCheck(index);
        return node(index).getObj();
    }

    public void remove(int index){
        rangeCheck(index);
        Node node = node(index);
        Node pre = node.getPrevious();
        Node next = node.getNext();
        pre.setNext(next);
        next.setObj(pre);
    }

    public boolean isOrdor(){
        Node temp = first;
        for (int i = 0; i < size; i++) {
            if((Integer)temp.getObj() > (Integer)temp.getNext().getObj())
                return false;
            temp = temp.getNext();
        }
        return true;
    }

    private Node node(int index){
        if(index < (size >> 1)){
            Node temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.getNext();
            }
            return temp;
        }
        else {
            Node temp = last;
            for (int i = size - 1; i > index; i--) {
                temp = temp.getPrevious();
            }
            return temp;
        }

    }

    private void rangeCheck(int index){
        if (index >= size){
            try {
                throw new IndexOutOfBoundsException();
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Index Out of Bounds");
            }
        }
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add("aaa");
        myLinkedList.add(124);
        myLinkedList.add(342);
        myLinkedList.add(134);
        myLinkedList.insertAt(3,89);
        System.out.println(myLinkedList.size);
        System.out.println(myLinkedList.get(0));
        System.out.println(myLinkedList.get(3)+"\n"+ myLinkedList.get(4));
    }
}

class Node{
    private Node previous;
    private Object obj;
    private Node next;

    public Node(Node previous, Object obj, Node next) {
        this.previous = previous;
        this.obj = obj;
        this.next = next;
    }

    public Node(){

    }

    public Node(Object obj){
        this.obj = obj;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public Object getObj() {
        return obj;
    }

    public Node getNext() {
        return next;
    }
}
