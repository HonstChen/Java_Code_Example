package com.itheima.test;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        //1.键盘录入机票原价，月份，头等舱或经济舱
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入机票的原价");
        int ticket = sc.nextInt();
        System.out.println("请输入当前月份");
        int month = sc.nextInt();
        System.out.println("请输入当前购买的舱位0头等舱1经济舱");
        int seat = sc.nextInt();
        if (month >= 5 && month <= 10) {
            //旺季
            //判断机票是经济舱还是头等舱
            ticket = getPrice(ticket, month, 0.9, 0.85);
        } else if ((month >= 1 && month <= 4) || (month >= 11 && month <= 12)) {
            //淡季
            ticket = getPrice(ticket, month, 0.7, 0.65);
        } else {
            //键盘录入不合法
            System.out.println("键盘录入不合法");
        }
        //2.旺季（5-10月）头等舱9折，经济舱8.5折，淡季（11月到4月）头等舱7折，经济舱6.5折
        System.out.println(ticket);
    }

    //1.我要干嘛?
    //2.我干这件事，需要什么才能完成
    //3.方法的调用是否需要继续使用这个结果
    public static int getPrice(int ticket, int seat, double v0, double v1) {
        if (seat == 0) {
            //头等舱
            ticket = (int) (ticket * v0);
        } else if (seat == 1) {
            //经济舱
            ticket = (int) (ticket * v1);
        } else {
            System.out.println("没有这个舱位");
        }
        return ticket;
    }
}
