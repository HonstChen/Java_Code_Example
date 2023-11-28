package com.itheima.test;

import java.util.Scanner;

public class Test10 {
    public static void main(String[] args) {
        System.out.println("请输入一个数字串");
        Scanner sc = new Scanner(System.in);
        String res = "";
        StringBuilder sb = new StringBuilder();
        String re = sc.next();
        if (checkStr(re)) {
            for (int i = 0; i < re.length(); i++) {
                sb.append(transform(re.charAt(i) - '0'));
            }
        } else {
            System.out.println("输入不合法");
        }
        System.out.println(sb);
    }

    public static boolean checkStr(String str) {
        if (str.length() > 9) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    public static String transform(int number) {
        String[] arr = {"", "Ⅰ", "Ⅱ", "Ⅲ", "Ⅳ", "Ⅴ", "Ⅵ", "Ⅶ", "Ⅷ", "Ⅸ"};
        return arr[number];
    }
}
