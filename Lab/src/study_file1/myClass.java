package study_file1;

public class myClass
{

    int a;   // so called  field(成员属性/成员变量）
    String classNumber;
    classmate clam;

    void play(int a, int b)   //  It is the normal method, so we use it must in Object
    {
        System.out.println(a+b);
    }

    static void play2()   //we can use the static method by not specifying the class
    {
        System.out.println("This is a static method, so it can be used directly");
    }

    public static void main(String[] args) {

        classmate Xiaoming = new classmate();
        Xiaoming.age = 19;
        Xiaoming.gender = Boolean.TRUE;
        Xiaoming.name = "Xiaoming";
        myClass  mc = new myClass();
        mc.play(1,2);
        play2();
        mc.a = 1713;
        mc.clam = Xiaoming;
        System.out.print(mc.clam.gender);
        System.out.print(mc.a+"\n");
        Xiaoming.print(mc.clam.name, mc.clam.age, Xiaoming.gender);// the problem has to be asked.
    }

//   private static void input()
//    {
//        classmate Xiaoming = new classmate();
//        Xiaoming.age = 19;
//        Xiaoming.gender = Boolean.TRUE;
//        Xiaoming.name = "Xiaoming";
//    }/

}

class classmate {

    String name;
    int age;
    Boolean gender; //True for man; False for woman

    static void print(String name, int age, Boolean gender)
    {   if (gender)
            System.out.printf("name:%s, age:%d, male", name, age);
        else
            System.out.printf("name:%s, age:%d, female", name, age);
    }
}



