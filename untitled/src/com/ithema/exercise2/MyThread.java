package com.ithema.exercise2;

public class MyThread extends Thread{
    static int count=100;
    static Object obj=new Object();

    @Override
    public void run() {
        while (true){
            synchronized (obj){
                //对临界资源进行判断
                if (count<10){
                    //停止运行
                    break;
                }else {
                    System.out.println(getName()+"分发了第"+count+"件礼物!");
                    count--;
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
            }
            }
        }
    }
}
