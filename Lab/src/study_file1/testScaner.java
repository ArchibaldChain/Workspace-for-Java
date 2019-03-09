package study_file1;
import java.util.*;

public class testScaner
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please input a string: ");
        String name = sc.nextLine();
        System.out.println("Please input a integer: ");
        int age = sc.nextInt();
        System.out.println(name+age);
    }
}
