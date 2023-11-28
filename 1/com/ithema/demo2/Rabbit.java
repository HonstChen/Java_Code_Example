package com.ithema.demo2;

public class Rabbit extends Animal {
    @Override
    public void eat() {
        System.out.println("兔子在吃胡萝卜");
    }

    public Rabbit(String name, int age) {
        super(name, age);
    }
}
