package Week3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.*;
import java.util.*;

public class MergeSort {
    private static LinkedList<Long>  numberA;
    private static LinkedList<Long>  numberB;
    private static LinkedList<Long>  MergeNumber;

    static PrintWriter out;
    static InputReader in;

    public static void main(String[] args) throws IOException{
//        out = new PrintWriter(System.out);
//        in = new InputReader(System.in);


        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        //StreamTokenizer.TT_EOF这个是个参数，就是EOF

        //本文来自 SUBEYZ 的CSDN 博客 ，全文地址请点击：https://blog.csdn.net/qq_38238041/article/details/78648192?utm_source=copy
        int number;
        int n,m;

        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            number = (int) in.nval;
            //int appears[] = new int[32768];// 记录出现次数

            for (int i = 0; i < number; i++) {
                in.nextToken();//指向下一个
                n = (int) in.nval;
                in.nextToken();//指向下一个
                m = (int) in.nval;

                numberA = new LinkedList<>();
                numberB = new LinkedList<>();
                MergeNumber = new LinkedList<>();
//


                for (int j = 0; j < n; j++) {
                    in.nextToken();//指向下一个
                    numberA.add((long)in.nval);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         }
                for (int j = 0; j < m; j++) {
                    in.nextToken();//指向下一个
                    numberB.add((long)in.nval);
                }
                link();

                Iterator iterator = MergeNumber.listIterator();
                while(iterator.hasNext()){
                    out.print((long)iterator.next());
                    out.print(" ");
                }
                out.println();
            }

            out.flush();//刷新，不然max会留在缓冲区//
        }




//                    //本文来自 SUBEYZ 的CSDN 博客 ，全文地址请点击：https://blog.csdn.net/qq_38238041/article/details/78648192?utm_source=copy
//        //number = in.nextInt();
//        number = new Integer(in.readLine());
//        for (int i = 0; i < number; i++) {
//            numberA = new LinkedList<>();
//            numberB = new LinkedList<>();
//            MergeNumber = new LinkedList<>();
////            n = in.nextInt();
////            m = in.nextInt();
//            n = new Integer(in.)
//
//            for (int j = 0; j < n; j++) {
//                numberA.add(in.
//                        nextLong());
//            }
//            for (int j = 0; j < m; j++) {
//                numberB.add(in.nextLong());
//            }
//            link();
//            Iterator iterator = MergeNumber.listIterator();
//            while(iterator.hasNext()){
//                out.print((long)iterator.next());
//                out.print(" ");
//            }
//            out.println();
//        }
//        out.close();
    }

    private static void link(){
        int i = 0, j = 0;

        while(i < numberA.size() && j < numberB.size()){

            if (numberA.get(i) > numberB.get(j)){
                MergeNumber.add(numberB.get(j));

                j++;
            }
            if (numberA.get(i) <= numberB.get(j)){
                MergeNumber.add(numberA.get(i));
                i++;

            }

        }
        while (i < numberA.size() ){
            MergeNumber.add(numberA.get(i));
            i++;
        }
        while (j < numberB.size() ){
            MergeNumber.add(numberB.get(j));
            j++;
        }
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



