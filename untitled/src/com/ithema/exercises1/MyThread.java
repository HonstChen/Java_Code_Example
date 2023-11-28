package com.ithema.exercises1;

public class MyThread extends Thread{
    //多线程卖票
    static int ticket=1000;
    static Object obj=new Object();
    @Override
    public void run() {
        while (true){
            synchronized (obj){
                if (ticket==0){
                    System.out.println("票卖完了");
                }else {
                    System.out.println(getName()+"正在卖第"+ticket+"张票!!!");
                    ticket--;
                    try {
                        Thread.currentThread().sleep(30);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
