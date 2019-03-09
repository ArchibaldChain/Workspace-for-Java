package Week14;

import java.util.*;

/**
 * ProjectName:    Data Structure and algorithm analysis
 * Author:         Archibald Chain
 * CreateDate:     2018/12/15 17:07
 * Version:        1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class BinarySearchTree{

    public static void main(String[] args) {
        Scanner s  = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();
        while(s.hasNext()){
            int a = s.nextInt();
            if ( a == 100)
                break;
            bst.add(a);
        }
        bst.levelOrder();
        while(s.hasNext()){
            int a = s.nextInt();
            if ( a == 100)
                break;
            bst.delete(a);
            bst.levelOrder();
        }
    }

    private Node root;
    private Node parent;
    private ArrayList<Integer> element;
    private HashMap<Integer, Node> node;

    class Node{
        private Node(int key) {
            this.key = key;
            if (root == null)
                root = this;
        }

        int key;
        Node leftChild;
        Node rightChild;
        Node parent;

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

    BinarySearchTree() {
        node = new HashMap<>();
    }

    void clear(){
        root = null;
    }

    void add(int key){
        if (root == null){
            root = new Node(key);
            return;
        }
        Node T = root;
        Node temp = new Node(key);
        do {
            if (!(key >T.key)){
                if (T.hasLeftChild())
                    T = T.leftChild;
                else{
                    T.leftChild = temp;
                    temp.parent = T;
                    break;
                }
            } else {
                if (T.hasRightChild())
                    T = T.rightChild;
                else{
                    T.rightChild = temp;
                    temp.parent = T;
                    break;
                }
            }
        }while(true);
        node.put(key, temp);
    }

    private Node find(int key)throws NoSuchElementException {
        return node.get(key);
    }

    private Node findParent(Node node){
//        T key = node.key;
//        Node t = root;
//
//        while(t != null){
//            if (t.leftChild == node){
//                return t;
//            }
//            if (t.rightChild == node){
//                return t;
//            }
//            if (!key.compareTo(t.key)){
//                t = t.leftChild;
//            } else{
//                t = t.rightChild;
//            }
//        }
//        return null;
        if (node == root)
            return null;
        return node.parent;
    }

    void delete(int key){

        Node node = this.node.remove(key);
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
            int temp;
            temp = smallest.key;

            deleteNode(smallest);
            node.key = temp;
        }
    }

    private Node getSmallest(Node node) {
        Node temp = node;

        while (temp.hasLeftChild()){
            parent = temp;
            temp = temp.leftChild;
        }

        return temp;
    }

    private void inOrder(Node node){
        if (node == null)
            return;
        inOrder(node.leftChild);
        element.add(node.key);
        inOrder(node.rightChild);
    }

    ArrayList<Integer> getElement() {
        element = new ArrayList<>();
        inOrder(root);
        return element;
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
}
