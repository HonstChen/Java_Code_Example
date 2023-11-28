package com.itheima.test;

import java.util.Random;
import java.util.Scanner;

public class Test11 {
    public static void main(String[] args) {
        String s;
        System.out.println("输入字符串");
        Scanner sc = new Scanner(System.in);
        s = sc.next();
        StringBuilder sb = new StringBuilder(s);
        System.out.println(s);
        Random r = new Random();
        for (int i = sb.length()-1; i > 0; i--) {
            int r_index = r.nextInt(i + 1);
            swap(sb, i, r_index);
        }
        System.out.println(sb);
    }

    public static void swap(StringBuilder sb, int i, int j) {
        char ch = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, ch);
    }
}
