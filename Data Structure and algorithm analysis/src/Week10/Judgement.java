package Week10;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

/**
 * @ProjectName: Data Structure and algorithm analysis
 * @Author: Archibald Chain
 * @CreateDate: 2018/11/17 11:41
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class Judgement {

    static FastReader scanner = FastReader.from(System.in);
    static FastWriter out = FastWriter.from(System.out);


    static int key[];
    static int parent[];
    static int children[];

    static boolean judge;

    static HashMap<Integer, Node> hashMap;
    public static void main(String[] args) {

        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            hashMap = new HashMap<>();
            int n = scanner.nextInt();
            key = new int[n + 1];
            parent = new int[n +1];
            children = new int[n+1];
            Node node[] = new Node[n+1];


            judge = true;
            for (int j = 1; j < n+1; j++) {
                key[j] = scanner.nextInt();
                node[j] = new Node(key[j]);
                hashMap.put(key[j], node[j]);
            }
            for (int j = 1; j < n; j++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();

                Node p = node[x];
                Node c = node[y];
                if (p.children.size() > 0){
                    if (p.children.size() >= 2){
                        judge = false;
                    }else if (p.children.get(0).key > c.key){
                        Node temp = p.children.remove(0);
                        p.children.add(c);
                        p.children.add(temp);
                    }else{
                        p.children.add(c);
                    }
                }else {
                    p.children.add(c);
                }
                c.parent = p;

            }

            int root = 1;
            for (int j = 1; j < n + 1; j++) {
                if (node[j].parent == null){
                    root = j;
                }
            }

            Node.inOrder = new ArrayList<>();
            node[root].inOrder();
            Iterator iterator = Node.inOrder.iterator();
            int temp = (Integer)iterator.next();
            while (iterator.hasNext()){
                int temp2 = (Integer)iterator.next();
                if (temp > temp2){
                    judge = false;
                    break;
                }
                temp = temp2;
            }

            if (judge)
                out.println("Case #"+(i+1)+ ": YES");
            else
                out.println("Case #"+(i+1)+ ": NO");

        }
    }

    static class Node{
        int key; // key is the where oj give

        Node parent;

        ArrayList<Node> children = new ArrayList<Node>();

        public Node(int key) {
            this.key = key;
        }

        static ArrayList<Integer> inOrder;

        private Iterator iter;

        public void inOrder(){
            iter = children.iterator();
            if(!iter.hasNext())
            {
                //System.out.print(key + " ");
                inOrder.add(key);
                return;
            }
            else
                ( (Node)(iter.next()) ).inOrder();
            if (inOrder.size() > 0 && key <= inOrder.get(inOrder.size()-1)){
                judge = false;
                return;
            }
            inOrder.add(key);
            if (iter.hasNext())
                ( (Node)(iter.next()) ).inOrder();
        }
    }
    static final class FastWriter {

        private final PrintWriter printWriter;

        private FastWriter(final PrintWriter printWriter) {
            this.printWriter = printWriter;

        }


        /**
         * Returns a {@link FastWriter} instance that prints output by {@code outputStreamWriter}.
         *
         * @param outputStream
         * @return Returns a {@link FastWriter} instance that prints output by {@code outputStreamWriter}.
         */
        public static final FastWriter from(final OutputStream outputStream) {
            return new FastWriter(new PrintWriter(new OutputStreamWriter(outputStream)));
        }


        /**
         * Terminates the current line by writing the line separator string.
         */
        public void println() {
            this.printWriter.println();
            this.printWriter.flush();
        }

        /**
         * Prints a boolean value and then terminate the line.
         *
         * @param x The <code>boolean</code> to be printed.
         */
        public void println(boolean x) {
            this.printWriter.println(x);
            this.printWriter.flush();
        }

        /**
         * Prints a character and then terminate the line.
         *
         * @param x The <code>char</code> to be printed.
         */
        public void println(char x) {
            this.printWriter.println(x);
            this.printWriter.flush();
        }

        /**
         * Prints an integer and then terminate the line.
         *
         * @param x The <code>int</code> to be printed.
         */
        public void println(int x) {
            this.printWriter.println(x);
            this.printWriter.flush();
        }

        /**
         * Prints a long integer and then terminate the line.
         *
         * @param x The <code>long</code> to be printed.
         */
        public void println(long x) {
            this.printWriter.println(x);
            this.printWriter.flush();
        }

        /**
         * Prints a floating-point number and then terminate the line.
         *
         * @param x The <code>float</code> to be printed.
         */
        public void println(float x) {
            this.printWriter.println(x);
            this.printWriter.flush();
        }

        /**
         * Prints an double-precision floating-point number and then terminate the line.
         *
         * @param x The <code>double</code> to be printed.
         */
        public void println(double x) {
            this.printWriter.println(x);
            this.printWriter.flush();
        }

        /**
         * Prints an array of characters and then terminate the line.
         *
         * @param x The array of <code>char</code> to be printed.
         */
        public void println(char[] x) {
            this.printWriter.println(x);
            this.printWriter.flush();
        }

        /**
         * Prints a String and then terminate the line.
         *
         * @param x The <code>String</code> value to be printed.
         */
        public void println(String x) {
            this.printWriter.println(x);
            this.printWriter.flush();
        }

        /**
         * Prints an Object and then terminate the line.
         *
         * @param x The <code>Object</code> to be printed.
         */
        public void println(Object x) {
            this.printWriter.println(x);
            this.printWriter.flush();
        }

        /**
         * Prints a boolean.
         *
         * @param x The <code>boolean</code> to be printed.
         */
        public void print(boolean x) {
            this.printWriter.print(x);
            this.printWriter.flush();
        }

        /**
         * Prints a character.
         *
         * @param x The <code>char</code> to be printed.
         */
        public void print(char x) {
            this.printWriter.print(x);
            this.printWriter.flush();
        }

        /**
         * Prints an integer.
         *
         * @param x The <code>int</code> to be printed.
         */
        public void print(int x) {
            this.printWriter.print(x);
            this.printWriter.flush();
        }

        /**
         * Prints a long integer.
         *
         * @param x The <code>long</code> to be printed.
         */
        public void print(long x) {
            this.printWriter.print(x);
            this.printWriter.flush();
        }

        /**
         * Prints a floating-point number.
         *
         * @param x The <code>float</code> to be printed.
         */
        public void print(float x) {
            this.printWriter.print(x);
            this.printWriter.flush();
        }

        /**
         * Prints an double-precision floating-point number.
         *
         * @param x The <code>double</code> to be printed.
         */
        public void print(double x) {
            this.printWriter.print(x);
            this.printWriter.flush();
        }

        /**
         * Prints an array of characters.
         *
         * @param x The array of <code>char</code> to be printed.
         */
        public void print(char[] x) {
            this.printWriter.print(x);
            this.printWriter.flush();
        }

        /**
         * Prints a String.
         *
         * @param x The <code>String</code> value to be printed.
         */
        public void print(String x) {
            this.printWriter.print(x);
            this.printWriter.flush();
        }

        /**
         * Prints an Object.
         *
         * @param x The <code>Object</code> to be printed.
         */
        public void print(Object x) {
            this.printWriter.print(x);
            this.printWriter.flush();
        }


        /**
         * Closes the output stream
         */
        public void close() {
            this.printWriter.close();
        }
    }

    static final class FastReader {
        private final BufferedReader bufferedReader;
        /* legacy class preferred over String#split and Scanner for performance */
        private StringTokenizer tokenizer;

        private FastReader(final BufferedReader bufferedReader) {
            this.bufferedReader = bufferedReader;
            this.tokenizer = null;
        }

        /**
         * Returns a {@link FastReader} instance that reads input from {@code inputStream}.
         *
         * @param inputStream
         * @return Returns a {@link FastReader} instance that reads input from {@code inputStream}.
         */
        public static final FastReader from(final InputStream inputStream) {
            return new FastReader(new BufferedReader(new InputStreamReader(inputStream)));
        }

        /**
         * Returns the next word acquired by {@link StringTokenizer}.
         * Moves on to the next line if the current line has been processed.
         *
         * @return Returns the next word acquired by {@link StringTokenizer},
         * or null if end of stream has been reached.
         * @throws RuntimeException If {@link java.io.BufferedReader#readLine()} throws an {@link IOException}.
         */
        public String next() {
            return tokenize() ? tokenizer.nextToken() : null;
        }

        /**
         * Checks to see if there are any more words left in the {@code inputStream}.
         * Can be used to check if end of stream has been reached, as well.
         * If required, reads another line from the {@code inputStream}; i.e this operation
         * might perform an I/O; possibly block if end of stream is not reached but stream
         * is not yet available to yield a new line.
         *
         * @return Returns true if there are more words to read in the {@code inputStream}
         * and end of stream has not been reached. False otherwise.
         * @throws RuntimeException If {@link java.io.BufferedReader#readLine()} throws an {@link IOException}.
         */
        public boolean canReadMore() {
            return tokenize();
        }

        private boolean tokenize() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                // read a line, see if end of stream has been reached
                String line = null;
                try {
                    if ((line = bufferedReader.readLine()) == null) return false;
                } catch (IOException unexpected) {
                    throw new RuntimeException(unexpected);
                }
                tokenizer = new StringTokenizer(line);
            }
            return true;
        }

        /**
         * Returns the next {@code int} acquired by {@link StringTokenizer}
         * using {@link Integer#parseInt(String)} on {@link #next()}.
         * Moves on to the next line if the current line has been processed.
         *
         * @return Returns the next {@code int} acquired by {@link StringTokenizer}.
         * @throws RuntimeException      If {@link java.io.BufferedReader#readLine()} throws an {@link IOException}.
         * @throws NumberFormatException If an invalid input is encountered or end of stream has been reached.
         */
        public int nextInt() {
            return Integer.parseInt(next());
        }

        /**
         * Returns the next {@code long} acquired by {@link StringTokenizer}
         * using {@link Long#parseLong(String)} on {@link #next()}.
         * Moves on to the next line if the current line has been processed.
         *
         * @return Returns the next {@code long} acquired by {@link StringTokenizer}.
         * @throws RuntimeException      If {@link java.io.BufferedReader#readLine()} throws an {@link IOException}.
         * @throws NumberFormatException If an invalid input is encountered or end of stream has been reached.
         */
        public long nextLong() {
            return Long.parseLong(next());
        }

        /**
         * Returns the next {@code double} acquired by {@link StringTokenizer}
         * using {@link Double#parseDouble(String)} on {@link #next()}.
         * Moves on to the next line if the current line has been processed.
         *
         * @return Returns the next {@code double} acquired by {@link StringTokenizer}.
         * @throws RuntimeException      If {@link java.io.BufferedReader#readLine()} throws an {@link IOException}.
         * @throws NumberFormatException If an invalid input is encountered or end of stream has been reached.
         */
        public double nextDouble() {
            return Double.parseDouble(next());
        }

        /**
         * Returns the next {@link BigDecimal} acquired by {@link StringTokenizer}
         * using BigDecimal's String constructor on {@link #next()}.
         * Moves on to the next line if the current line has been processed.
         *
         * @return Returns the next {@code BigDecimal} acquired by {@link StringTokenizer}.
         * @throws RuntimeException      If {@link java.io.BufferedReader#readLine()} throws an {@link IOException}.
         * @throws NumberFormatException If an invalid input is encountered or end of stream has been reached.
         */
        public BigDecimal nextBigDecimal() {
            return new BigDecimal(next());
        }

        /**
         * Returns the next {@link BigInteger} acquired by {@link StringTokenizer}
         * using BigInteger's String constructor on {@link #next()}.
         * Moves on to the next line if the current line has been processed.
         *
         * @return Returns the next {@code BigInteger} acquired by {@link StringTokenizer}.
         * @throws RuntimeException      If {@link java.io.BufferedReader#readLine()} throws an {@link IOException}.
         * @throws NumberFormatException If an invalid input is encountered or end of stream has been reached.
         */
        public BigInteger nextBigInteger() {
            return new BigInteger(next());
        }

        /**
         * Closes the input stream.
         *
         * @throws RuntimeException If {@link java.io.BufferedReader#readLine()} throws an {@link IOException}.
         * @see java.io.BufferedReader#close()
         */
        public void close() {
            try {
                bufferedReader.close();
            } catch (IOException unexpected) {
                throw new RuntimeException(unexpected);
            }
        }
    }

}