package Week1;

import java.util.Scanner;

import static java.lang.Math.pow;

public class BeautifulPair {

    static private int[][] accumulate;
    static private short[] lowUp; //lower false;  Up true;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        input.nextLine();
        String string;
        for (int i = 0; i < number; i++) {

            string = input.nextLine();
            accumulate = new int[19][19];


            int left = series(string.charAt(0));
            int right;
            for (int j = 1; j < string.length(); j++) { //Initialize
                //left = series(string.charAt(j-1));
                right = series(string.charAt(j));

                if (left == -1||right == -1){
                    left = right;
                    continue;
                }
//                System.out.println("left = " + left);
//                System.out.println("right = " + right);
                accumulate[left][right] ++;
                left = right;
            }

            System.out.println(search());
        }
    }

    private static int search(){
        lowUp = new short[19];
        int temp = 0;

        for (int i = 0; i < (int)pow(2,19); i++) {
            int sum = 0;
            setLowUp(i); // Initialize the letter(capital or not)
            for (int j = 0; j < accumulate.length; j++) {

                for (int k = 0; k < accumulate[j].length; k++) {

                    if(lowUp[k] != lowUp[j])
                    {
                        sum += accumulate[j][k];
                    }
                }
            }
            if(sum>temp)
                temp = sum;
        }
        return temp;
    }

    static private void setLowUp(int number){

        for (int i = 0; i < 19; i++) {
            int a = number%((int)pow(2,i+1));
            int b = (int)pow(2,i);
            lowUp[i] = (short)(a/b);
        }
    }

    private static int series(char letter){
        switch(letter){
            case 'a': return -1;
            case 'b': return 0;
            case 'c': return 1;
            case 'd': return 2;
            case 'e': return -1;
            case 'f': return 3;
            case 'g': return 4;
            case 'h': return 5;
            case 'i': return -1;
            case 'j': return 6;
            case 'k': return 7;
            case 'l': return 8;
            case 'm': return 9;
            case 'n': return 10;
            case 'o': return -1;
            case 'p': return 11;
            case 'q': return 12;
            case 'r': return 13;
            case 's': return 14;
            case 't': return 15;
            case 'u': return -1;
            case 'v': return 16;
            case 'w': return -1;
            case 'x': return 17;
            case 'y': return -1;
            case 'z': return 18;
        }
        return -1;
//        int num = -1;
//        if (letter == 'a'|| letter == 'e'|| letter == 'i'|| letter == 'o'|| letter == 'u'||
//                letter == 'w'||letter == 'y'){
//            return -1;
//        }
//        for (int i = 0; i < 26; i++) {
//            if ('a'+i == 'a'||'a'+i == 'e'||'a'+i == 'i'||'a'+i == 'o'||'a'+i == 'u'||
//            'a'+i == 'w'||'a'+i == 'u'){
//                continue;
//            }
//
//            if(letter == 'a'+i){
//                break;
//            }
//
//            num++;
//        }
//        return num;
    }

}
