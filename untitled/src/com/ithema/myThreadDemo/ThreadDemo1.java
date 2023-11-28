package com.ithema.myThreadDemo;

public class ThreadDemo1 {
    public static void main(String[] args) {
        //程序调用star开启线程
        MyThread t1=new MyThread("女神");
        MyThread2 t2=new MyThread2();
        t1.setName("女神");
        t2.setName("备胎");

        //把第二个线程设置为守护线程(备胎线程)
        t2.setDaemon(true);

        t1.start();
        t2.start();
        //两个线程交替进行
        //线程优先级
        /*System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());*/

    }
}
