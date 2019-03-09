package Unnamed;

public class Packaging {
    public static void main(String[] args) {

        User_[] Student = new User_[100];

        for(int i = 0; i < Student.length+0; i++)
        {
            Student[i] = new User_();
        }
        for(int i = 1; i < Student.length+1; i++)
        {
            Student[i- 1].setID(18000+i);
        }
        for(User_ m : Student)
        {
            System.out.println(m.getID());
        }

    }
}

class User_{

    private int ID;
    private String name;
    private boolean gender;
    private int age;
    static int a = 1;

    public void setName(String name){
        this.name = name;
    }

    public  void setID(int id){
        this.ID = id;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public boolean isGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }


}
