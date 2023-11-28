package com.ithema.myThreadDemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyRunnable implements Runnable{
    int ticket=0;
    static Lock lock=new ReentrantLock();
    @Override
    public void run() {
        //1.循环
        //2.同步代码块（同步方法）
        //3.判断共享数据是否到了末尾，如果到了末尾
        //4.判断共享数据是否到了末尾，如果没有到末尾
        /*while (true) {
                if (method()) break;
        }*/
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
    //this，抽取成为同步方法
    //Ctrl+Alt+M抽取为方法块
    private synchronized boolean method() {
        if (ticket==100){
            return true;
        }else {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            ticket++;
            System.out.println(Thread.currentThread().getName()+"在卖第"+ticket+"张票!!!");
        }
        return false;
    }
}
