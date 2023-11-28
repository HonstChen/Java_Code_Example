package com.ithema.myThreadDemo;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        //求1到100之间的和
        int sum=0;
        for (int i=1;i<=100;i++){
            sum+=i;
        }
        return sum;
    }
}
