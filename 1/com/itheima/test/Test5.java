package com.itheima.test;

import java.util.Arrays;
import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        //六名评委，求出平均值，去除最高分和最低分
        int[] grades = new int[6];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < grades.length; i++) {
            int t = sc.nextInt();
            grades[i] = t;
        }
        float res = getAvg(grades);
        System.out.println(res);
    }

    public static float getAvg(int[] grades) {
        Arrays.sort(grades);
        float sum = 0;
        for (int i = 1; i < grades.length - 1; i++) {
            sum += grades[i];
        }
        return sum / (grades.length - 2);
    }
}
