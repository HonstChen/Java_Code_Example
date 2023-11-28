package com.ithema.waitQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class Cook extends Thread{
    ArrayBlockingQueue<String> ab;

    public Cook(ArrayBlockingQueue<String> ab) {
        this.ab = ab;
    }

    @Override
    public void run() {
        while (true){
            //不断从阻塞队列中加入
            try {
                ab.put("面条");
                System.out.println("厨师放了一碗面条");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
