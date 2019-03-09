package Assignment4;

import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;


public class Entropy {

    public static int[] charCount(String s) {
        if (s == null) return null;
        int count[] = new int[26];
        for (char m:s.toCharArray()) {
            count[m - 97] ++;
        }
        int loop = 0;
        for (int i = 0; i < count.length; i++)
        {
            if (count[i] == 0)
                continue;
            loop ++;
        }
        int charCount[] = new int[loop];
        int j = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0)
                continue;
            charCount[j] = count[i];
            j++;
        }
        return charCount;
    }

    static double[] normalize(int[] c){
        if (c == null) return null;
        int sum = 0;
        double normalize[] = new double[c.length];
        for(int m:c) sum += m;
        for (int i = 0; i < c.length; i++) {
            normalize[i] = (double)c[i] / sum;
        }
        return normalize;
    }

    static double entropyOf(double[] p){
        if (p == null)return 0;
        double entropyOf = 0;
        for (int i = 0; i < p.length; i++) {
            entropyOf -= p[i]*Math.log(p[i]);
        }
        return entropyOf;
    }

    static int[][]  charCountArray(String[] a){
        if (a == null)return null;
        int count[][] = new int[a.length][26];
        int charCountArray[][] = new int[a.length][];

        /**
         * 此循环用于数出字符数量
         */
        for (int k = 0; k < a.length; k++)
        {
            if (a[k] == null)
                continue;
            for (char m : a[k].toCharArray())
            {

                count[k][m - 97]++;
            }
        }

        count = check(count);

        ArrayList<ArrayList<Integer>> as = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            as.add(new ArrayList<>());
            for (int j = 0; j < count[i].length; j++) {
                if (count[i][j] == 0) continue;
                as.get(i).add(count[i][j]);
            }
        }

        for (int i = 0; i < a.length; i++) {
            int[] abc = new int[as.get(i).size()];
            for (int j = 0; j < as.get(i).size(); j++) {
                abc[j] = as.get(i).get(j);
            }
            charCountArray[i] = abc;
        }
        return charCountArray;
    }

    public static int[][] check(int count[][]){
        /**
         * 此method用于将重复的部分全部变为零
         */
        for (int i = 0; i < 26; i++)
        {
            int sum = 0;
            for (int j = 0; j < count.length; j++)
            {
                    sum += count[j][i];
            }
            for (int j = 0; j < count.length; j++)
            {
                if((sum != count[j][i])&&(count[j][i] != 0))  //找到重复的部分
                {
                    for (int k = 0; k < count.length; k++)
                    {
                        count[k][i] = 0;  //让重复的部分为零
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        /*
        *Character Probabilities in hello  : [0.2, 0.2, 0.4, 0.2]
Entropy of hello  :  1.332
Entropy of world  :  1.609
Entropy of unique chars in hello  : 0.693
Entropy of unique chars in world  : 1.099
        * */
        int a;
        switch (args.length){
            case 0:
                System.out.println("end");return;
            case 1:
                a = 1;break;
            default:
                a = 2; break;
        }


        System.out.println("Character Probabilities in "+args[0]+"  : "
                    +Arrays.toString(normalize(charCount(args[0]))));


        for (int i = 0; i < a; i++) {
            System.out.printf("Entropy of  %s : %.3f\n",
                    args[i], entropyOf(normalize(charCount(args[i])))
            );
        }

        int uniqueChar[][] = charCountArray(args);

        for (int i = 0; i < a; i++) {
            System.out.printf("Entropy of unique chars in %s : %.3f\n",
                    args[i], entropyOf(normalize(uniqueChar[i]))
            );
        }
    }
}
