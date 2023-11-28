package com.ithema.myThreadDemo;

public class ThreadDemo2 {
    public static void main(String[] args) {
        //1.自己定义一个类来实现Runable接口
        //2.重写里面的run方法
        //3.创建自己的类对象
        //4.创建一个Thread类的对象，并且开启线程
        MyRun mr=new MyRun();

        //创建线程对象
        Thread t1=new Thread(mr);
        Thread t2=new Thread(mr);

        //给线程设置名字
        t1.setName("线程1");
        t2.setName("线程2");

        //开启线程
        t1.start();
        t2.start();
    }
}
