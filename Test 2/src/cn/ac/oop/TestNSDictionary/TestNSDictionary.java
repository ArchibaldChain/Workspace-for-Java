package cn.ac.oop.TestNSDictionary;

public class TestNSDictionary {

    /**
     * NSDictionary Method
     */

    public static <T> void figure(T t){
        System.out.println(t);
    }

    public static <T extends TestNSDInterface> void get(T... a){
        for (T temp:a) {
            temp.abc(new Student<Integer>(), "abc");
        }
    }
}



/**
 * T type
 * K,V key,value
 * E element
 * ? Unknown
 */

class Student<T>{
    T Name;
}
