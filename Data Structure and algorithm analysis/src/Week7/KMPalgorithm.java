package Week7;

public class KMPalgorithm {

    private static int[] KMParray;

    public static void main(String[] args) {
        String b = "abaabcac";//"aabaabaaa";
        char[] a = b.toCharArray();
        setTheKMPArray(a);
        for (int i = 0; i < KMParray.length; i++) {
            System.out.print(KMParray[i]);
        }
    }

    public static void KMPimplement(String text, String pattern){
        char[] txt = text.toCharArray();
        char[] pat = pattern.toCharArray();

        setTheKMPArray(pat);

        for (int i = 0,j = 0; i < txt.length; i++) {

            if(txt[i] == pat[j]){
                j++;

            } else {
                while(j > 0){
                    j = KMParray[j - 1];
                    if(txt[i] == pat[j]){
                        j++;
                        break;
                    }
                }
            }

            if (j == pat.length){
                System.out.println("The string at: "+ (i-j +1)+" is the first of the found place");
                j = 0;
            }
        }



    }

    private static void setTheKMPArray(char[] pat){

        KMParray = new int[pat.length];
        KMParray[0] = 0;

        int pre = 0;
        int suf = 1;
        int i = 0;

        while (suf < pat.length){
            if(pat[pre] == pat[suf]){
                // when the longest suffix still equals longest previous
                KMParray[suf] = ++i;
                pre++;
                suf++;
            } else {
                while(pre > 0){
                    pre = KMParray[pre - 1];
                    if(pat[suf] == pat[pre]){
                        ++pre;
                        break;
                    }

                }
                i = pre;
                KMParray[suf] = i;
                suf ++;
            }
        }
    }
}
