package cn.ac.oop.polymorphism;

public class Animal {
    int weight = 50;
    int height = 2;
    void run(){
        System.out.println("Animal.run");

    }
    void getWeight(){
        System.out.println("Animal.getWeight");
        System.out.println("weight = " + weight);
    }
}

class Elephant extends Animal{
    int weight = 100;
    double noseLong = 1.5;
    @Override
    void run(){
        System.out.println("Elephant.run");
    }

    @Override
    void getWeight() {
        System.out.println("Elephant.getWeight");
        System.out.println("weight = " + weight);
        System.out.println("height = " + height);
    }
    void jump(){
        System.out.println("Elephant.jump");
    }
}