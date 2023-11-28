package com.ithema.myThreadDemo;

public class ThreadDemo6 {
    public static void main(String[] args) {
        //利用同步方法来完成售票服务
        //技巧：同步代码块抽取为抽象方法

        MyRunnable mr=new MyRunnable();

        Thread t1=new Thread(mr);
        Thread t2=new Thread(mr);
        Thread t3=new Thread(mr);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
