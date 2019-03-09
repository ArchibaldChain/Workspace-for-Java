package Week10;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @ProjectName: Data Structure and algorithm analysis
 * @Author: Archibald Chain
 * @CreateDate: 2018/11/17 10:39
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class CompleteBinaryTree {

    static PrintWriter out;
    static InputReader in;

    static int root;
    static int left[];
    static int right[];
    static int value[];
    static int levelOrder[];

    public static void main(String[] args) {
        out = new PrintWriter(System.out);
        try {
            in = new InputReader(System.in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int number = in.nextInt();

            left = new int[number+1];
            right = new int[number+1];
            value = new int[number+1];
            levelOrder = new int[number +1];

            for (int j = 1; j < number+1; j++) {
                int x = in.nextInt();
                int y = in.nextInt();

                left[j]= x;
                right[j] = y;
                value[x] ++;
                value[y] ++;
            }
            root = 1;
            for (int j = 1; j < number + 1; j++) {
                if (value[j] == 0)
                    root = j;
            }
            value[root] = 1;
            for (int j = 1; j < number+1; j++) {

                value[left[j]] = value[j] *2;
                value[right[j]] = value[j] *2 +1;
            }

            //setValue(root, 1);
            levelOrder(root);

            boolean judge = true;
            for (int j = 1; j < number + 1; j++) {
                if (value[j] != levelOrder[j]){
                    judge = false;
                    break;
                }

            }
            if (judge)
                out.println("Yes");
            else
                out.println("No");
        }



        out.close();
    }

    static public void setValue(int key, int val){
        if (key == 0){
            return;
        }
        value[key] = val;
        if(left[key] != 0 && left[key] != key)
            setValue(left[key], val *2);
        if (right[key]!= 0 && right[key] != key)
            setValue(right[key], val *2+ 1);
    }

    private static Queue<Integer> queue = new LinkedList<Integer>();

    private static void levelOrder(int root){

        queue.add(root);



        for (int i = 1; i < levelOrder.length && !queue.isEmpty(); i++) {


            int key = queue.poll();

            if (left[key] != 0)
                queue.add(left[key]);

            if (right[key] != 0)
                queue.add(right[key]);
            levelOrder[key] = i;
        }

    }

//    class Node{
//        int key; // key is the where oj give
//        int value; //value is number
//
//        Node parent;
//
//        Node leftSon;
//        Node rightSon;
//
//        public Node(int key, int value) {
//            this.key = key;
//            this.value = value;
//        }
//
//        public Node(int key, int value, Node parent) {
//            this.key = key;
//            this.value = value;
//            this.parent = parent;
//        }
//    }
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