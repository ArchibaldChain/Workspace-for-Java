package cn.ac.oop.testInterClass;

public class Outer {
    public static void main(String[] args) {
        Face f = new Face();
        Face.Nose n = f.new Nose();
        n.breath();
        Face.Ear e = new Face.Ear();
        e.listen();

    }
}

class Face{
    int type = 2;
    String shape = "瓜子脸";
    static int a = 2;

    /**
     * 普通内部类
     * 必须存在在外部类里
     * 不得定义静态属性方法
     * 可以访问外部类的属性
     * 通过 OuterClass.this.property
     */
    class Nose{

        String type = "dddd";
        void breath(){
            System.out.println("Breath");
            System.out.println(Face.this.type);
            System.out.println(type);
            System.out.println(shape);
        }
        Face.Ear ab = new Face.Ear();
       // ab.listen();
    }

    /**
     * 静态内部类
     *
     * 不可以使用外部类的普通属性
     * 可以使用外部类的静态属性
     */
    static class Ear {
        void listen(){
            System.out.println("Listen");
            System.out.println(a);
        }
    }

    void emoji(){
        System.out.println("Laugh");
    }
}
