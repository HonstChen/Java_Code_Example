package com.ithema.myThreadDemo;

public class ThreadDemo4 {
    public static void main(String[] args) {
        //创建线程对象
        MyThread111 t1=new MyThread111();
        MyThread111 t2=new MyThread111();
        MyThread111 t3=new MyThread111();

        //起名字
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        //synchronized锁

        //开启线程
        t1.start();
        t2.start();
        t3.start();
    }
}
