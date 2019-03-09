package cn.ac.oop.testInterface;

public interface InterfaceAAA {
    int abc = 12;
    void AAA();
}

interface InterfaceBBB{
    void BBB();
}

interface InterfaceCCC extends InterfaceAAA,InterfaceBBB{
    void CCC();
}

class TestClass implements InterfaceCCC{
    int abc = 10;
    @Override
    public void AAA(){
        System.out.println("MyClass.AAA"+abc);
    }

    @Override
    public void BBB() {
        System.out.println("MyClass.BBB"+abc);
    }

    @Override
    public void CCC() {
        System.out.println("MyClass.CCC");
    }

    public static void main(String[] args) {
        InterfaceAAA in = new TestClass();
        System.out.println(in.abc);
        in.AAA();
        System.out.println("********转型后*****************");
        TestClass tc = (TestClass)in;
        System.out.println(tc.abc);
        tc.BBB();
        System.out.println("*****************************");
        InterfaceCCC in2 = new TestClass();
        System.out.println(in2.abc);
        in2.AAA();
        in2.BBB();
        System.out.println("********转型后*****************");
        TestClass tc2 = (TestClass)in2;
        System.out.println(tc2.abc);
        in2.AAA();
        in2.BBB();
        System.out.println("*****************************");
        TestClass in3 = new TestClass();
        System.out.println("in3.abc = " + in3.abc);
    }
}