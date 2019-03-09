package cn.ac.oop.testFile;

import java.io.File;
import java.io.IOException;

public class testCreateFile {
    public static void main(String[] args) {
        File f0_path = new File("C:\\Programing\\Workspace for Java\\" +
                                         "Test 2\\src\\cn\\ac\\oop\\testFile");
        File f1 = new File(f0_path,"CreatedClass.java");
        File f2 = new File(
                "C:\\Programing\\Workspace for Java\\Test 2\\src\\" +
                        "cn\\ac\\oop\\testFile\\newText.txt");
        try {
            f1.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(f1.isFile());
        System.out.println(f1.isDirectory());
        System.out.println(f0_path.isAbsolute());
        File f3 = new File(f0_path, "aa/bb/cc\\newText.txt");
        f3.mkdir();
        f3.mkdirs();
        try {
            f3.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(f3.isFile());
        System.out.println("f2 = " + f2.isFile());
        try {
            f2.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
