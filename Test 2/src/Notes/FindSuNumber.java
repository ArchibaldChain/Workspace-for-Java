package Notes;

import java.util.Scanner;

/**
 * ProjectName:    Test 2
 * Author:         Archibald Chain
 * CreateDate:     2019/4/11 19:53
 * Version:        1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class FindSuNumber {


    static int count;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        count = 0;
        int n = scanner.nextInt();
        int suNumber;
        boolean judge = true;
        for (int i = 2; i <= n; i++) {
            judge = true;
            suNumber = 2;
            while(suNumber <= i && judge){
                for (int j = 1; j <= 10; j++) {
                    if (Math.pow(suNumber,j) == i){
                        System.out.print(i);
                        System.out.print(" ");
                        count ++;
                        judge = false;
                        break;
                    }

                }
                suNumber = findNextSuNumber(suNumber);
            }
        }
        System.out.println(count);
    }

    static int findNextSuNumber(int a){
        boolean judge = true;
        for (int i = a + 1;; i++) {
            judge = true;
            for (int j = 2; j < Math.sqrt(i); j++) {
                if (i % j == 0){
                    judge = false;
                    break;
                }

            }
            if (judge){
                return i;
            }
        }

    }

}
