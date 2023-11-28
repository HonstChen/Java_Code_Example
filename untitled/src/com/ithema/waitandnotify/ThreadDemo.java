package com.ithema.waitandnotify;

public class ThreadDemo {
    public static void main(String[] args) {
        Foodie foodie=new Foodie();
        Cook cook=new Cook();

        //给线程设置名字
        cook.setName("厨师");
        foodie.setName("吃货");

        //开启线程
        cook.start();
        foodie.start();
    }
}
