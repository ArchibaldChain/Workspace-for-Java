package cn.ac.oop.polymorphism;

public class TestPolymorphyism {
    public static void main(String[] args) {
        Animal a = new Elephant();
        System.out.println(a.weight+"  "+a.height+"  ");
        a.getWeight();
        //a.jump;  error
        System.out.println("**************************");
        Elephant b = (Elephant)a;
        System.out.println(b.weight+"  "+b.height+"   "+b.noseLong);
        b.getWeight();
        b.jump();
    }
}
/**
 *  多态的时候调用子类重写了父类的方法，而不能调用自己独有的方法，同时调用父类的属性
 */
