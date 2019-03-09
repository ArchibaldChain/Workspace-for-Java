package project;

import java.io.*;


public class FileIO {
    public static String normallyFileReader(String path, String code){

        StringBuilder al = new StringBuilder();

        try{
            String myCode = code!=null&&!"".equals(code) ? code : "UTF8";
            Reader reader = new InputStreamReader(new FileInputStream(path), myCode);
            BufferedReader bf = new BufferedReader(reader);
            String a;
            // read line by line
            while ((a = bf.readLine()) != null){
                al.append(a);
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
        return al.toString();
    }

    public static void fileWriter(String path, String content){
        path = path.replace('\\', '/');
        int i = path.lastIndexOf('/');
        char[] item = path.toCharArray();
        item[i] = '}';

        //String strs = Arrays.toString(item);
        String str = String.copyValueOf(item);

        System.out.println(path);
        String[] dir = str.split("}");

        try {
            File dirPath = new File(dir[0]);
            if (!dirPath.exists()) {
                dirPath.mkdirs();
            }
        } catch (Exception e) {
            System.out.println("创建多层目录操作出错: "+e.getMessage());
            e.printStackTrace();
            return;
        }

        File file_name = new File(dir[0], dir[1]);
        if(!file_name.exists()){
            try {
                file_name.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try{

            Writer wr = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(wr);
            bw.write(content+'\n');
            bw.close();
            wr.close();

            System.out.println("Finish Writing");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
