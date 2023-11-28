package com.itheima.test;

import java.util.Random;

public class Test7 {
    public static void main(String[] args) {
        //随机抽取{2,588,888,1000,10000}五个奖金，随机且不重复
        int[] arr = {2, 588, 888, 1000, 10000};
        int[] newarr = new int[arr.length];
        Random rand = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        for (int i : arr) {
            System.out.printf("%d ", i);
        }
    }

}
