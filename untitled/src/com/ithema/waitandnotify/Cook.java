package com.ithema.waitandnotify;

public class Cook extends Thread{
    @Override
    public void run() {
        //重写run方法
        //1.循环
        while (true){
            synchronized (Desk.lock){
                if (Desk.count==0){
                    break;
                }else {
                    //判断桌子上是否有面条
                    if (Desk.foodFlag==1){
                        try {
                            Desk.lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                    }else {
                        //没有面条，调用生产者逻辑程序
                        //生产面条
                        System.out.println("厨师已经做好了");
                        //修改标识
                        Desk.foodFlag=1;
                        //通知其他程序
                        Desk.lock.notifyAll();
                    }
                }
            }
        }
        //2.同步代码块
        //3.判断是否到了末尾
        //4.没到末尾，执行核心逻辑

    }
}
