
package Week2;


import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class SportMeeting {
    static private long[] relayDistance;
    static private int m;
    static private long answer;


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;

        while (input.hasNext()) {
            long L = input.nextInt();
            n = input.nextInt();
            m = input.nextInt();
            long distance[] = new long[n];
            relayDistance = new long[n + 1];
            for (int i = 0; i < n; i++) {
                distance[i] = input.nextInt();
            }
            Arrays.sort(distance);
            relayDistance[0] = distance[0];
            for (int i = 1; i < n; i++) {
                relayDistance[i] = distance[i] - distance[i - 1];
            }
            relayDistance[n] = L - distance[n - 1];
            binaryDividen(1, (long) Math.pow(10, 9));

            System.out.println(answer);
        }

    }

    private static void binaryDividen(long a, long b) {
        if (Math.abs(a - b) == 0) {
            answer = a;
            return;
        }
        long med = (a + b) / 2;
        if (judge(med)) {
            binaryDividen(med +1, b);
        } else
            binaryDividen(a, med);
    }

    private static boolean judge(long l) {
        long times = 0;
        boolean jg = true;
        for (int i = 0; i < relayDistance.length && jg; i++, times++) {
            long temp = relayDistance[i];
            if(relayDistance[i] > l)
                return true;
            while (i + 1 < relayDistance.length && temp + relayDistance[i + 1] <= l) {
                temp += relayDistance[++i];
            }
        }
        if (times > m)//which means l is smaller or equal than the answer
            return true;
        else            //which means l is larger than the answer
            return false;
    }
}

/*class CompareMachine implements Comparable {

    private long object;

    public CompareMachine(long object) {
        this.object = object;
    }

    public long getObject() {
        return object;
    }

    @Override
    public int compareTo(Object obj){
        CompareMachine wf = (CompareMachine) obj;
        if(wf.object <= this.object){
            return -1;
        }
        if(wf.object > this.object){
            return 1;
        }
        return 0;
    }
}*/
