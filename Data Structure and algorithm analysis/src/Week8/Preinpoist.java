package Week8;


import java.io.*;
import java.util.*;


public class Preinpoist {
    static PrintWriter out;
    static InputReader in;


    private static int[] left;
    private static int[] right;
    public static void main(String[] args) {
        out = new PrintWriter(System.out);
        try {
            in = new InputReader(System.in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int n = in.nextInt();

        int number;
        for (int i = 0; i < n; i++) {
            number = in.nextInt();

            left = new int[number+1];
            right = new int[number+1];
            int[] isChild = new int[number + 1];
            int temp1, temp2;
            for (int j = 0; j < number-1; j++) {
                temp1 = in.nextInt();
                temp2 = in.nextInt();
                if (left[temp1] == 0){
                    left[temp1] = temp2;
                } else
                    right[temp1] = temp2;
                isChild[temp2]++;
            }

            int root = 0;
            for (int j = 1; j <= number; j++) {
                if(isChild[j] == 0)
                    root = j;
            }
            pre(root);
            out.print("\n");
            inOrder(root);
            out.print("\n");
            postOrder(root);
        }





        //replace System.out.println()
        out.close();
        //Don't forget this line, otherwise you will output nothing. This sentence flush the buffer.
    }



    static void pre(int node){
        if(node == 0)
            return;
        out.print(node+ " ");
        pre(left[node]);
        pre(right[node]);
    }

    static void inOrder(int node){
        if(node == 0)
            return;
        inOrder(left[node]);
        out.print(node+ " ");
        inOrder(right[node]);
    }

    static void postOrder(int node){
        if(node == 0)
            return;
        postOrder(left[node]);
        postOrder(right[node]);
        out.print(node+ " ");
    }
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
