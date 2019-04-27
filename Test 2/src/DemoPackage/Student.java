package DemoPackage;

/**
 * ProjectName:    Test 2
 * Author:         Archibald Chain
 * CreateDate:     2019/4/20 19:08
 * Version:        1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class Student {
    private int ID;
    private String name;
    private int age;
    Computer computer = new Computer();
    final int I = 0;

    public Student(int ID, String name, int age) {
        this.ID = ID;
        this.name = name;
        this.age = age;
    }

    public Student(){
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 1 || age >100)
        {
            this.age = 18;
            return;
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student"+ name +
                " is " + age +
                '}';
    }

    public static void main(String[] args) {
        Student a = new Student();
        System.out.println(a.name);
        Student b = new Student(11, "Archibald", 18);
        System.out.println(b);
    }

}

class Computer{
     String brand;
}
