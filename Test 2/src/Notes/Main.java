package Notes;

import java.util.Scanner;

/**
 * ProjectName:    Test 2
 * Author:         Archibald Chain
 * CreateDate:     2019/4/11 19:35
 * Version:        1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        String strings;
        String output;
        for (int i = 0; i < number; i++) {
            strings = scanner.nextLine();
            if (strings.length() < 10)
                System.out.println(strings);
            else
                output = strings.toCharArray()[0] + strings.length()
                        +""+strings.toCharArray()[strings.length()-1];

        }
    }
}
