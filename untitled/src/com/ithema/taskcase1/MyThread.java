package com.ithema.taskcase1;

import java.util.Random;

public class MyThread extends Thread{
    static double money=100.0;
    static int count=3;

    //定义最小的中奖金额
    static final double MIN=0.01;

    @Override
    public void run() {
        synchronized (MyThread.class){
            if (count==0){
                //判断共享数据是否已经到了末尾
                System.out.println(getName()+"没有抢到红包!");
            }else {
                //判断，共享数据没有到达末尾
                //无需随机，剩余的所有的钱都是中奖金额
                double prize=0;
                if (count==1){
                    prize=money;
                }else {
                    Random r=new Random();
                    double bounds = money - (count - 1) * MIN;
                    prize=r.nextDouble(bounds);
                    if (prize<MIN) {
                        prize = MIN;
                    }
                }

                //从money当中，去掉当前的中奖金额
                money-=prize;
                count--;
                System.out.println(getName()+"抢到了"+prize+"元");
            }
        }
    }
}
