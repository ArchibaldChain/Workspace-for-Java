package Week10;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @ProjectName: Data Structure and algorithm analysis
 * @Author: Archibald Chain
 * @CreateDate: 2018/11/17 14:53
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class BubbleSort {

    static PrintWriter out;
    static InputReader in;

    public static void main(String[] args) {
        BubbleSort bs = new BubbleSort();
        out = new PrintWriter(System.out);
        try {
            in = bs.new InputReader(System.in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int t = in.nextInt();

        MinHeap minHeap = new MinHeap();
        for (int i = 0; i < t; i++) {

            int n = in.nextInt();
            int K = in.nextInt();
            int a[] = new int[n];
            int b[] = new int[n];
            int k = 0;
            for (int j = 0; j < n; j++) {
                a[j] = in.nextInt();
                minHeap.add(a[j]);
                if (minHeap.size > K){
                    b[k] = minHeap.deleteMin();
                    k++;
                }
            }
            while (minHeap.size > 0 && k < b.length){
                b[k] = minHeap.deleteMin();
                k++;
            }

            for (int j :b) {
                System.out.print(j + " ");
            }

            System.out.println();


        }
        out.close();
    }

    private static class MinHeap {
        private int[] minHeap;
        private int size;

        public MinHeap(int root) {
            this.minHeap = new int[2048];
            this.minHeap[1] = root;
            this.size = 1;
        }

        public MinHeap() {
            this.size = 0;
        }

        public int size() {
            return this.size;
        }

        public int getMin() {
            return this.minHeap[1];
        }

        public void add(int n) {
            if (this.minHeap == null){
                this.minHeap = new int[2048];
            }
            if (this.size == minHeap.length - 1) {
                doublesize();
            }

            this.size++;
            int index = size();

            //percolate up
            for (; index > 1 && n < minHeap[index / 2]; index = index / 2) {
                minHeap[index] = minHeap[index / 2];
            }
            minHeap[index] = n;

        }

        public int deleteMin() {
            if (size == 0) {
                throw new RuntimeException("Delete when the heap is empty");
            }
            int min = minHeap[1];
            minHeap[1] = minHeap[size];
            size--;
            percolateDown(1);
            return min;
        }

        private void percolateDown(int i) {
            int temp = minHeap[i];
            int child;

            for (; 2 * i <= size; i = child) {
                child = 2 * i;

                // go to right child
                if (child != size && minHeap[child] > minHeap[child + 1]) {
                    child++;
                }

                if(temp > minHeap[child]){
                    minHeap[i] = minHeap[child];
                }else{
                    break;
                }
            }
            minHeap[i] = temp;

        }

        private void doublesize() {
            int[] old = minHeap;
            minHeap = new int[2 * minHeap.length];
            System.arraycopy(old, 1, minHeap, 1, size);

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
}
