package Week10;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Scanner;


/**
 * @ProjectName: Data Structure and algorithm analysis
 * @ClassName: ${TYPE_NAME}
 * @Author: Archibald Chain
 * @CreateDate: 2018/11/15 15:36
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */

public class BinarySearchTree {

    private Node root;
    private Node parent;

    class Node{
        private Node(int key) {
            this.key = key;
            if (root == null)
                root = this;
        }

        int key;
        Node leftChild;
        Node rightChild;

        private boolean hasChild(){
            return !(leftChild == null && rightChild == null);
        }

        private boolean hasLeftChild(){
            return !(leftChild == null);
        }

        private boolean hasRightChild(){
            return !(rightChild == null);
        }

        private boolean hasOneChild(){
            return this.hasLeftChild() ^ this.hasRightChild();
        }

        private Node getOnlyOneChild(){
            if (this.hasOneChild()){
                if (this.hasLeftChild())
                    return leftChild;
                if (this.hasRightChild())
                    return rightChild;
            }
                throw new NullPointerException("Not Has One Child");

        }
    }

    public void add(int key){
        if (root == null){
            root = new Node(key);
            return;
        }
        Node T = root;
        do {
            if (key <= T.key){
                if (T.hasLeftChild())
                    T = T.leftChild;
                else{
                    T.leftChild = new Node(key);
                    break;
                }
            } else {
                if (T.hasRightChild())
                    T = T.rightChild;
                else{
                    T.rightChild = new Node(key);
                    break;
                }
            }
        }while(true);
    }

    private Node find(int key)throws NoSuchElementException {
        Node t = root;
        while(t != null){
            if (key == t.key){
                return t;
            }else if (key < t.key){
                t = t.leftChild;
            } else{
                t = t.rightChild;
            }
        }
        throw new NoSuchElementException("Not Found");
    }

    private Node findParent(Node node){
        int key = node.key;
        Node t = root;

        while(t != null){
            if (t.leftChild == node){
                return t;
            }
            if (t.rightChild == node){
                return t;
            }
            if (key <= t.key){
                t = t.leftChild;
            } else{
                t = t.rightChild;
            }
        }
        return null;
    }

    public void delete(int key){

        Node node = null;
        try {
            node = find(key);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        parent = findParent(node);
        deleteNode(node);

    }

    private void deleteNode(Node node){
        Node smallest;
        if (!node.hasChild()){
            if (parent == null){
                root = null;
                return;
            }
            if (parent.leftChild == node){
                parent.leftChild = null;
            }
            if (parent.rightChild == node){
                parent.rightChild = null;
            }
        } else if (node.hasOneChild()){
            if (parent == null){
                root = node.getOnlyOneChild();
                return;
            }
            if (parent.leftChild == node){
                parent.leftChild = node.getOnlyOneChild();
            }
            if (parent.rightChild == node){
                parent.rightChild = node.getOnlyOneChild();
            }
        } else {
            parent = node;
            smallest = getSmallest(node.rightChild);
            int temp = smallest.key;

            deleteNode(smallest);
            node.key = temp;
        }
    }

    public Node getSmallest(Node node) {
        Node temp = node;

        while (temp.hasLeftChild()){
            parent = temp;
            temp = temp.leftChild;
        }

        return temp;
    }

    private Queue<Node> queue = new LinkedList<Node>();

    public void levelOrder(){
        if (root == null){
            System.out.println("No Entry");
            return;
        }
        queue.add(root);

        Node node;
        while (!queue.isEmpty()){
            node = queue.poll();

            if (node.hasLeftChild())
                queue.add(node.leftChild);
            System.out.print(node.key + " ");
            if (node.hasRightChild())
                queue.add(node.rightChild);
        }

    }

    public static void inOrder(Node node){
        if (node == null)
            return;
        inOrder(node.leftChild);
        System.out.print(node.key + " ");
        inOrder(node.rightChild);
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();


        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int a = scanner.nextInt();
            if (a == 100){
                break;
            }
            bst.add(a);
        }
        bst.inOrder(bst.root);

        while (scanner.hasNext()){
            int a = scanner.nextInt();
            if (a == 100){
                break;
            }
            try {
                bst.delete(a);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(a + "is not found");
            }
            bst.inOrder(bst.root);
        }

//        bst.delete(2);
//        bst.delete(-4);
//        bst.delete(-53);
//        bst.delete(3);
//        bst.delete(75);
        System.out.println();
        //bst.levelOrder();

        System.out.println();
 //       inOrder(bst.root);
    }
}
