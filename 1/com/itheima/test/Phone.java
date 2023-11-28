package com.itheima.test;

public class Phone {
    private String brand;
    private double price;

    public Phone() {

    }

    public Phone(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    public void call() {
        System.out.println("正在打电话");
    }

    public void playGame() {
        System.out.println("正在打游戏");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
