package com.ithema.waitQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class ThreadDemo {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> arrayBlockingQueue=new ArrayBlockingQueue<String>(1);
        //阻塞队列要指定最大的容量
        //capicity

        Cook cook=new Cook(arrayBlockingQueue);
        Foodie foodie=new Foodie(arrayBlockingQueue);

        //设置名字
        cook.setName("厨师");
        foodie.setName("吃货");
        //启动线程
        cook.start();
        foodie.start();
    }
}
