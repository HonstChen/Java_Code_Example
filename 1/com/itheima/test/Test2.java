package com.itheima.test;

import java.util.Scanner;

import static java.lang.Math.sqrt;

public class Test2 {
    //判断101到200之间有多少个素数
    //思路;2到平方根
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nums1 = sc.nextInt();
        int nums2 = sc.nextInt();
        int res = get(nums1, nums2);
        System.out.println(res);
    }

    public static int get(int nums1, int nums2) {
        int res = 0;
        for (int i = nums1; i < nums2; i++) {
            if (judge(i)) {
                res++;
            }
        }
        return res;
    }

    public static boolean judge(int num) {
        boolean flag = true;
        for (int i = 2; i < sqrt(num); i++) {
            if (num % i == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
