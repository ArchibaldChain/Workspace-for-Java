package cn.ac.oop.testException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class testReadFileException {
    public static void main(String[] args) {
        try {
            Thread.sleep(2000);//checked Exception
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        /**
         * 一个较为完善的读取文件的用例
         */
        FileReader fr = null;
        try {
            fr = new FileReader("c:\\a.txt");
            char a = (char)fr.read();
        } catch (FileNotFoundException e) {
            e.printStackTrace();  // This is the " 子类"Exception
        } catch (IOException e){
            e.printStackTrace();  // "父类" Exception
        } finally {
            try {
                if(fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
