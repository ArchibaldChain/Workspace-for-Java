package lab11;

import java.util.Scanner;

public class User {
    private String userId;
    private String username;
    private String password;
    private static int id;

    public User(String username, String passoword) {
        this.username = username;
        this.password = passoword;
        id++;
        this.userId="User"+String.valueOf(id);

    }


    public void changePassword(){
        Scanner input=new Scanner(System.in);
        System.out.println("Input password:");
        setPassword(input.next());
        input.close();
    }

    public void setPassword(String password){
        this.password=password;
    }

    @Override
    public String toString() {
        return "[userId=" + userId + ", username=" + username
                + ", password=" + password + "]";
    }

    public static void main(String args[]){
        AdminUser u1=new AdminUser("Bob","aaabbb");
        OrdinaryUser u2=new OrdinaryUser("Emma","aaadddd");
        System.out.println(u1.toString());
        System.out.println(u2.toString());
        u1.resetPassword(u2);
        u2.recharge(1000);
        u2.pay(1200);
        System.out.println(u2);
    }

}