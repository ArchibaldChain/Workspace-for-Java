package lab11;

import java.io.*;
import java.util.Arrays;

class Person {

    private String name;
    private int born;
    private String country;

    public Person(String name, int born, String country) {
        this.name = name;
        this.born = born;
        this.country = country;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBorn(int born) {
        this.born = born;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public int getBorn() {
        return born;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Person [name="+name+", born="+born+", country="+country+"]";
    }
}

public class Exercise {
    public static String fileReader(String path) {
        StringBuilder sb = new StringBuilder("");

        try{
            Reader reader = new InputStreamReader(new FileInputStream(path), "UTF-8");
            BufferedReader bf = new BufferedReader(reader);
            String a;
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

    public static void main(String[] args) {

        System.out.println("Begin to read person.txt");
        String[] resource = fileReader("person.txt").split("\n");

        System.out.println("Begin to read cn_person.txt");
        String[] resource2 = fileReader("cn_person.txt").split("\n");

        int strLen1=resource.length;//保存第一个数组长度
        int strLen2=resource2.length;//保存第二个数组长度
        resource = Arrays.copyOf(resource,strLen1+ strLen2);//扩容
        System.arraycopy(resource2, 0, resource, strLen1,strLen2 );//将第二个数组与第一个数组合并
        Person[] a = new Person[resource.length];

        for (int i = 0; i < resource.length; i++) {
            String[] message = resource[i].split(",");
            a[i] = new Person(message[0], Integer.parseInt(message[1]), message[2]);
        }

        StringBuilder sb = new StringBuilder();
        for (Person per: a) {
            sb.append(per+"\n");
        }

        System.out.println("Begin to write all.txt");
        fileWriter("all.txt", sb.toString());

    }
}
