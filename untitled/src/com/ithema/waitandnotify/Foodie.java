package com.ithema.waitandnotify;

public class Foodie extends Thread{
    @Override
    public void run() {
        //1.循环
        //2.同步代码块
        //3.判断是否到了末尾
        //4.没到末尾，执行核心逻辑

        while (true){
            synchronized (Desk.lock){
                if (Desk.count==0){
                    break;
                }else {
                    //判断桌子上是否有面条
                    if (Desk.foodFlag==0){
                        //如果没有，就等待
                        try {
                            Desk.lock.wait();//当前线程跟锁进行绑定
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                    }
                    else {
                        //如果有，就开吃
                        //把吃的总数-1
                        Desk.count--;
                        System.out.println("吃货在吃面条，还能再吃"+Desk.count+"碗!!!");
                        Desk.lock.notifyAll();
                        //修改桌子的状态
                        Desk.foodFlag=0;
                    }
                }
            }
        }
    }
}
