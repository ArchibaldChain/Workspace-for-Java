package cn.ac.oop.abstractClass;

public abstract class Animal {
    /**
     * Abstract method: The extended method has to override the abstract method and it cannot have a body
     * The abstract class can strictly control the design of the extended class.
     *
     * The abstract class cannot be instantiate.
     */
    public abstract void run();

    public void breath(){
        run();
    }

}

class Cat extends Animal{
    @Override
    public void run() {
        System.out.println("Cat.run()");
    }
}
