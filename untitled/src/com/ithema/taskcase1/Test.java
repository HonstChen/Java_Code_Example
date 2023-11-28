package com.ithema.taskcase1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {

        //创建线程对象
        /*MyThread t1=new MyThread();
        MyThread t2=new MyThread();
        MyThread t3=new MyThread();
        MyThread t4=new MyThread();
        MyThread t5=new MyThread();

        t1.setName("小A");
        t2.setName("小QQ");
        t3.setName("小HH");
        t4.setName("小湿湿");
        t5.setName("小丹丹");


        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();*/

        //1.获取线程池的对象
        ExecutorService pool = Executors.newFixedThreadPool(3);
        //2.提交任务
        pool.submit(new MyRunnable());
        pool.submit(new MyRunnable());
        pool.submit(new MyRunnable());
        pool.submit(new MyRunnable());
        pool.submit(new MyRunnable());

        //3.销毁线程池
        pool.shutdown();

    }
}
