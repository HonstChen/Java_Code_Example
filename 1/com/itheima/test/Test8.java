package com.itheima.test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Test8 {
    public static void main(String[] args) {
        //1.生成中奖号码
        int[] arr = creatNumber();
        for (int i : arr) {
            System.out.printf("%d ", i);
        }
        //2.让用户输入彩票号码(红球＋蓝球)

    }

    public static int[] creatNumber() {
        //1.创建数组添加中将号码
        int[] arr = new int[7];
        //2.随机生成号码并添加到数组中
        //红球:不能重复的 1 2 3 4 5 6
        //蓝球:可以和红球的号码重复 5

        //生成红球的号码并添加到数组当中
        Random r = new Random();
        HashSet<Integer> hS = new HashSet<>();
        for (int i = 0; i < 6; i++) {
            //获取红球号码
            int redNumber = r.nextInt(33) + 1;
            if (hS.contains(redNumber)) {
                i--;
            } else {
                hS.add(redNumber);
                arr[i] = redNumber;
            }
        }
        arr[6] = r.nextInt(16) + 1;
        return arr;
    }
    //用于数字在数组中是否存在
}
