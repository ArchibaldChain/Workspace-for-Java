package Unnamed;

class User extends person{

    public boolean equals(Object obj) {

        if(obj == null) return false;
        if(getClass() != obj.getClass()) return false;
        User other = (User)obj;
        System.out.println(this.ID+""+other.ID);
        return this.ID == other.ID;

    }

    User(){}

    User(int ID,String Name){

        this.ID = ID;
        this.Name = Name;
    }

    User(int ID, String Name, String password){

        this.ID = ID;
        this.Name = Name;
        this.passWord = password;
    }
}

class person{

    int ID;
    int age;
    String Name;
    String passWord;

//    public person(int ID, int age, String Name, String passWord){
//
//        this.ID = ID;
//        this.age = age;
//        this.Name = Name;
//        this.passWord = passWord;
//    }

    static void method1() {
        System.out.println("I am born with the god.");
    }


}

public class RestructionOfConstructedMethod {

    public static void main(String[] args){

        User XiaoMing = new User();
        User XiaoHong = new User(00000, "XiaoHong","342323");
        System.out.println(XiaoHong.ID);
        User XiaoBai = new User(11112, "XiaoBai","643yfhf");
        XiaoHong.ID = 123456;
        System.out.println(XiaoHong.ID);
        System.out.println(XiaoBai.ID);
//        System.out.println(XiaoMing instanceof person);
//        System.out.println(XiaoMing instanceof User);
//        System.out.println(XiaoMing instanceof Object);
//        System.out.println('\n');
        System.out.println(XiaoBai == XiaoHong);
        System.out.println(XiaoBai.ID == XiaoHong.ID);
        System.out.println(XiaoBai.Name == XiaoHong.Name);
        System.out.println(XiaoBai.passWord == XiaoHong.passWord);

        System.out.println(XiaoHong.equals(XiaoBai));
        System.out.println(XiaoHong.ID);

    }

}


