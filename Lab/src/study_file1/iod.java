package study_file1;
import java.io.*;

public class iod
{
    public static void main(String[] args)
    {
        String str = "";
        int n;

        System.out.print("Please input a character: ");
        BufferedReader  buf = new BufferedReader(new InputStreamReader(System.in));
        //str = buf.readLine(); // Input a string     // UNKNOW PROBLEM
        System.out.println("The string is" + str);

        n = Integer.parseInt(str);
        System.out.println(n);
    }
}
