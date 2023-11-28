package com.itheima.test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Test6 {
    public static void main(String[] args) {
        //加密规则，先得到每位数，然后没位数加上5，再对10求余数，最后反转，得到新的数字。
        System.out.println("请输入你需要转化的数字");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            list.add(Character.getNumericValue(str.charAt(i)));
        }
        ArrayList<Integer> res = encrypt(list);
        for (int i : res) {
            System.out.printf("%d", i);
        }
        res = decode(res);
        System.out.println(" ");
        for (int i : res) {
            System.out.printf("%d", i);
        }
    }

    public static ArrayList<Integer> encrypt(ArrayList<Integer> nums) {
        for (int i = 0; i < nums.size(); i++) {
            nums.set(i, ((nums.get(i) + 5) % 10));
        }
        for (int star = 0, end = nums.size() - 1; star < end; star++, end--) {
            int temp = nums.get(star);
            nums.set(star, nums.get(end));
            nums.set(end, temp);
        }
        return nums;
    }

    public static ArrayList<Integer> decode(ArrayList<Integer> nums) {
        Collections.reverse(nums);
        //反转,解密
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) <= 4 && nums.get(i) >= 0) {
                nums.set(i, nums.get(i) + 10);
            }
            nums.set(i, nums.get(i) - 5);
        }
        return nums;
    }
}
