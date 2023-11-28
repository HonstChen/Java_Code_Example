package com.ithema.demo2;

public class Dog extends Animal implements Swim {

    @Override
    public void eat() {
        System.out.println("狗在吃骨头");
    }

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void swim() {
        System.out.println("狗刨");
    }
}
