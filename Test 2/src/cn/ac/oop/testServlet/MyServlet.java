package cn.ac.oop.testServlet;

public class MyServlet extends HttpServlet{
    @Override
    public void doGet() {
        System.out.println("MyServlet.doGet()");
    }
}
