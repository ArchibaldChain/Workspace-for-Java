package Unnamed;

class Father{
    int ID;
    int age;

    public Father(int ID, int age){
        this.ID = ID;
        this.age = age;
    }

    void speak(){
        System.out.println("I am the father\n"+"My ID is "+this.ID);
    }
}

class Son extends Father{

    Son(int ID, int age){
        super(ID, age);
    }
}


public class SuperMethodTest{
    public static void main(String[] args) {
        Son A = new Son(12345, 12);
        A.speak();
        Son B = new Son(54321, 9);
        A.speak();
        B.speak();
    }
}