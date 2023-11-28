package com.itheima.test;

import java.util.ArrayList;
import java.util.Scanner;

public class Test12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        String s1 = sc.nextLine();
//        String s2 = sc.nextLine();
//        String s3 = String.valueOf(Integer.parseInt(s1) * Integer.parseInt(s2));
//        System.out.println(s3);
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            arr.add(i);
        }
        Integer j = 3;
        arr.remove(3);
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }
}
