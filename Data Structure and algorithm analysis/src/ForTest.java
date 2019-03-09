import java.util.ArrayList;
import java.util.HashMap;

public class ForTest {
    public static void main(String[] args) {

        ArrayList<Node> arrayList = new ArrayList<>();
        arrayList.add(new Node(1));
        arrayList.add(new Node(2));
        arrayList.add(new Node(3));
        Node[] nodes = arrayList.toArray(new Node[0]);
        nodes[0].num = 5;
        for (Node n : nodes) {
            System.out.print(n.num);
            System.out.print(" ");
        }
        System.out.println();
        nodes = arrayList.toArray(new Node[0]);

        for (Node n : nodes) {
            System.out.print(n.num);
            System.out.print(" ");
        }

    }
}

class Node{
    int num;

    public Node(int num) {
        this.num = num;
    }
}
