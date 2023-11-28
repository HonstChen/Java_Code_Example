package com.ithema.demo;

public class Frog extends Animal implements Swim {
    @Override
    public void eat() {
        System.out.println("青蛙在吃虫子");
    }

    public Frog(String name, int age) {
        super(name, age);
    }

    @Override
    public void swim() {
        System.out.println("蛙泳");
    }
}
