package Week9;

import java.io.*;
import java.util.*;


public class Tree {
    static int longestDistance;

    static PrintWriter out;
    static InputReader in;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        out = new PrintWriter(System.out);

        int n = in.nextInt();

        int number;
        for (int i = 0; i < n; i++) {
            number = in.nextInt();

            TreeNode treeNode[] = new TreeNode[number + 1];
            for (int j = 0; j < number+1; j++) {
                treeNode[j] = new TreeNode();
            }
            int[] isChild = new int[number + 1];
            int temp1, temp2;
            for (int j = 1; j < number + 1; j++) {
                treeNode[j].key = j;
            }
            for (int j = 0; j < number - 1; j++) {

                temp1 = in.nextInt();
                temp2 = in.nextInt();
                treeNode[temp1].children.add(treeNode[temp2]);
                isChild[temp2]++;

            }

            int root = 0;
            for (int j = 1; j <= number; j++) {
                if(isChild[j] == 0)
                    root = j;
            }

            treeNode[root].getDepth();
            System.out.println("longestDistance = " + longestDistance);
            //out.println("Ask question");
            /**
             * 1. for the out.println
             * 2. arraylist.iterator.next;
             */


            treeNode[root].preOrder();
            System.out.println();
            treeNode[root].inOrder();
            System.out.println();
            treeNode[root].postOrder();
            System.out.println();

            TreeNode.levelOrder(treeNode[root]);

        }

        out.close();
        //Don't forget this line, otherwise you will output nothing. This sentence flush the buffer.
    }




}

class TreeNode{
    int key;
    ArrayList<TreeNode> children = new ArrayList<TreeNode>();

    public int getDepth(){
        if (children.isEmpty())
            return 0;
        int max = 0, secondMax = 0;
        int depth[] = new int[children.size()];
        for (int i = 0; i < children.size(); i++) {
            depth[i] = children.get(i).getDepth();
            if(depth[i] > max){
                secondMax = max;
                max = depth[i];
            }
            if (depth[i] > secondMax && secondMax <= max ){
                secondMax = depth[i];
            }
        }

        Tree.longestDistance = secondMax + max + 2;
        return max + 1;
    }

    private Iterator iter;

    public void preOrder(){
        iter = children.iterator();
        if(!iter.hasNext())
        {
            System.out.print(key + " ");
            return;
        }

        System.out.print(key+ " ");
        while (iter.hasNext()){
            ((TreeNode)(iter.next())).preOrder();
        }
    }

    public void inOrder(){
        iter = children.iterator();
        if(!iter.hasNext())
        {
            System.out.print(key + " ");
            return;
        }
        else
            ( (TreeNode)(iter.next()) ).inOrder();
        System.out.print(key + " ");
        if (iter.hasNext())
            ( (TreeNode)(iter.next()) ).inOrder();
    }

    public void postOrder(){
        iter = children.iterator();
        if(!iter.hasNext())
        {
            System.out.print(key + " ");
            return;
        }

        else
            ( (TreeNode)(iter.next()) ).postOrder();
        if (iter.hasNext())
            ( (TreeNode)(iter.next()) ).postOrder();

        System.out.print(key + " ");

    }

    public static void levelOrder(TreeNode root){
        queue.add(root);
        Iterator iter;
        TreeNode treeNode;
        while (!queue.isEmpty()){
            treeNode = queue.poll();
            System.out.print(treeNode.key + " ");
            iter = treeNode.children.iterator();
            while(iter.hasNext()){
                queue.add((TreeNode)iter.next());
            }
        }

    }

    private static Queue<TreeNode> queue = new LinkedList<TreeNode>();
}

class InputReader {
    public BufferedReader br;
    public StringTokenizer tokenizer;
    public InputReader(InputStream stream) throws FileNotFoundException {
        br = new BufferedReader(new InputStreamReader(stream), 327680);
        tokenizer = null;
    }
    public boolean hasNext(){
        while(tokenizer == null || !tokenizer.hasMoreElements())
        {
            try
            {
                tokenizer = new StringTokenizer(br.readLine());
            }
            catch(Exception e)
            {
                return false;
            }
        }
        return true;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }
    public int nextInt() {
        try {
            int c = br.read();
            while (c <= 32) {
                c = br.read();
            }
            boolean negative = false;
            if (c == '-') {
                negative = true;
                c = br.read();
            }
            int x = 0;
            while (c > 32) {
                x = x * 10 + c - '0';
                c = br.read();
            }
            return negative ? -x : x;
        }catch(IOException e){
            return  -1;
        }
    }
    public long nextLong() {
        try {
            int c = br.read();
            while (c <= 32) {
                c = br.read();
            }
            boolean negative = false;
            if (c == '-') {
                negative = true;
                c = br.read();
            }
            long x = 0;
            while (c > 32) {
                x = x * 10 + c - '0';
                c = br.read();
            }
            return negative ? -x : x;
        }catch(IOException e){
            return  -1;
        }
    }

}


