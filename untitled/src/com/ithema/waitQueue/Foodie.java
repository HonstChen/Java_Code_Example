package com.ithema.waitQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class Foodie extends Thread{
    ArrayBlockingQueue<String> ab;

    public Foodie(ArrayBlockingQueue<String> ab) {
        this.ab = ab;
    }

    @Override
    public void run() {
        while (true){
            //不断从阻塞队列中获取面条
            try {
                String food = ab.take();
                System.out.println(food);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
