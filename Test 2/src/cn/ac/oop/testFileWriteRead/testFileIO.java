package cn.ac.oop.testFileWriteRead;

import java.io.*;
import java.util.Scanner;

public class testFileIO{
    public static String fileReader(String path) {
        StringBuilder sb = new StringBuilder("");

        try{
            Reader reader = new InputStreamReader(new FileInputStream(path), "UTF-8");
            BufferedReader bf = new BufferedReader(reader);
            String a = null;
            // read line by line
            while ((a = bf.readLine()) != null){
                sb.append(a+"\n");
            }
            bf.close();
            reader.close();

            System.out.println("Finish Reading");
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static void fileWriter(String path, String content){
        try{
            Writer wr = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(wr);
            bw.write(content);
            bw.close();
            wr.close();

            System.out.println("Finish Writing");
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {


        String str = fileReader("C:\\Users\\Archibald Chain\\Desktop\\新建文本文档.txt");
        System.out.println(str+"ok");
        //fileWriter();


        fileWriter("src\\cn\\ac\\oop\\testFile\\newText.txt",str);
        str = fileReader("src\\cn\\ac\\oop\\testFile\\newText.txt");
        System.out.println(str);
    }
}

