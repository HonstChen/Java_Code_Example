package com.ithema.myThreadDemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread111 extends Thread{
    static int ticket=0;
    //共享的静态变量

    //锁对象，一定要唯一
    static Object obj=new Object();
    //锁对象相当于一把锁，一定要唯一才行
    static Lock lock=new ReentrantLock();
    @Override
    public void run() {
        //锁不能写在while循环的外面
        //如果写在里面，窗口1会直接卖完所有的票
        while (true){
            lock.lock();
            try {
                if (ticket==100){
                    break;
                }else {
                    Thread.sleep(10);
                    ticket++;
                    System.out.println(Thread.currentThread().getName()+"在卖第"+ticket+"张票!!!");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }
}
