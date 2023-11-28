package com.ithema.myThreadDemo;

public class ThreadDemo5 {
    public static void main(String[] args) {
        //synchronized锁
        //锁默认打开，有一个线程进去了，锁自动关闭
        //里面的代码全部执行完毕，线程出来，锁自动打开
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
