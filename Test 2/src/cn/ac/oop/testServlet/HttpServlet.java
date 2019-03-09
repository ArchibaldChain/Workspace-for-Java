package cn.ac.oop.testServlet;

public class HttpServlet {
    public void service(){
        System.out.println("HttpServlet.service()");
        doGet();
    }

    public void doGet(){
        System.out.println("HttpServlet.doGet()");
    }
}
