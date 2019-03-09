package Unnamed;

public class OverridesTest {
    public static void main(String[] args){
        car Baomao = new car();
        Baomao.Xiaoming();
        String[] str = {"123","564","hug"};
        RestructionOfConstructedMethod.main(str);


    }

}

class vehicle{

    person Xiaoming(){
        System.out.println("person Xiaoming");
        return new person();
    }

}

class car{
    User Xiaoming(){
        System.out.println("User Xiaoming");
        return new User();
    }

}