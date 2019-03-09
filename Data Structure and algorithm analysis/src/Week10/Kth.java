package Week10;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @ProjectName: Data Structure and algorithm analysis
 * @Author: Archibald Chain
 * @CreateDate: 2018/11/17 14:37
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class Kth {

    static PrintWriter out;
    static InputReader in;

    public static void main(String[] args) {
        Kth k = new Kth();
        out = new PrintWriter(System.out);
        try {
            in = k.new InputReader(System.in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int t = in.nextInt();
        for (int i = 0; i < t; i++) {

            int n = in.nextInt();
            int K = in.nextInt();
            int a[] = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = in.nextInt();
            }

            Arrays.sort(a);
            out.println(a[a.length - K]);


        }
        out.close();
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
}
