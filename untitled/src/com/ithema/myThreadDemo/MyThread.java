package com.ithema.myThreadDemo;

public class MyThread extends Thread{
    public MyThread() {
    }

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        //重写run方法
        for (int i = 1; i <= 10; i++) {
            System.out.println(getName()+"@"+i);
        }
    }
}
