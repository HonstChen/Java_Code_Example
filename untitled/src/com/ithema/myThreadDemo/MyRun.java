package com.ithema.myThreadDemo;

public class MyRun implements Runnable {

    @Override
    public void run() {
        //书写线程要执行的代码
        Thread thread = Thread.currentThread();
        for (int i = 0; i < 100; i++) {
            //获取到当前线程的对象
            System.out.println(thread.getName() + "HelloWorld");
        }
    }
}
