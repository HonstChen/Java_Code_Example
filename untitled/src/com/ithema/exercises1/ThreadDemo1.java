package com.ithema.exercises1;

public class ThreadDemo1 {
    //一共用1000张电影票，可以在两个窗口领取，假设领取的间隔为3000毫秒
    //要求：用多线程模拟卖票的过程，并且打印电影票的数量
    public static void main(String[] args) {
        //创建两个线程
        MyThread t1=new MyThread();
        MyThread t2=new MyThread();

        t1.setName("窗口1");
        t2.setName("窗口2");

        t1.start();
        t2.start();
    }
}
