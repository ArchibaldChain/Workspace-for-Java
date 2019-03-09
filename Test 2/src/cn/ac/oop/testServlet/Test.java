package cn.ac.oop.testServlet;

public class Test {
    public static void main(String[] args) {
        HttpServlet s = new MyServlet();
        s.doGet();
        System.out.println("************");
        s.service();
    }
}
