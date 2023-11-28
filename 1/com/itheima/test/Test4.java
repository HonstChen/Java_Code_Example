package com.itheima.test;

public class Test4 {
    public static void main(String[] args) {
        //把一个数组的元素复制到另外一个新数组中去
        //1.定义一个老数组并存储一些元素
        int[] arr = {1, 2, 3, 4, 5};

        int[] newarr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            newarr[i] = arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(newarr[i]);
        }
    }
}
