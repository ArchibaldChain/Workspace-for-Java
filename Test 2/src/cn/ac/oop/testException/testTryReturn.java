package cn.ac.oop.testException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class testTryReturn {
    public static void main(String[] args) {
        String str = new testTryReturn().openFile();
        System.out.println("MAIN  "+str);
    }

    String openFile(){
        try {
            System.out.println("aaa");
            FileInputStream fis = new FileInputStream("C:/dsd.java");
            int a = fis.read();
            System.out.println("In the Try...");
            return "abc";
        } catch (FileNotFoundException e) {
            System.out.println("catch1");
            e.printStackTrace();
            return "Catch1";
        } catch (IOException e){
            e.printStackTrace();
            return "Catch2";
        } finally {
            System.out.println("Finally");
            //return "Finally";
        }
        //return "down";
    }
    /**
     * After the finally than the return will be executed
     */
}
