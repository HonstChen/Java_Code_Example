package com.itheima.test;

public class Test9 {
    public static void main(String[] args) {
        Phone phone = new Phone();
        Phone phone1 = new Phone("苹果", 6000);
        phone.call();
        phone.playGame();
        System.out.println(phone.getBrand());
        System.out.println(phone.getPrice());
        System.out.println(phone1.getBrand());
        System.out.println(phone1.getPrice());
    }
}
