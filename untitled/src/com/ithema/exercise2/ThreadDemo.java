package com.ithema.exercise2;

public class ThreadDemo {
    public static void main(String[] args) {
        MyThread t1=new MyThread();
        MyThread t2=new MyThread();

        t1.setName("A");
        t2.setName("B");

        t1.start();
        t2.start();
    }
}
