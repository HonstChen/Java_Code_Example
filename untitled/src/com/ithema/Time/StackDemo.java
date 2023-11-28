package com.ithema.Time;

import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        /*System.out.println(getSum(100));
        System.out.println(getSum1(1000000000));*/

    }

    public static long getSum1(int number) {
        long res = 0;
        for (int i = 1; i <= number; i++) {
            res += i;
        }
        return res;
    }

    public static int getSum(int number) {
        if (number == 1) {
            return 1;
        }
        return number + getSum(number - 1);
    }

    public static void method() {
        method();
    }
}
