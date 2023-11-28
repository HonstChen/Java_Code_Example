package com.ithema.Time;

import java.time.*;

public class A02_InstantDemo {
    public static void main(String[] args) {

        //1.获取当前时间的Instant对象(标准时间)
        Instant now = Instant.now();
        //System.out.println(now);

        //2.根据制定的秒，毫秒，纳秒获取Instant对象
        Instant instant = Instant.ofEpochMilli(0L);
        //System.out.println(instant);
        LocalDate nowDate = LocalDate.now();
        System.out.println(nowDate);

        int year = nowDate.getYear();
        System.out.println(year);
        Month month = nowDate.getMonth();
        System.out.println(month);

        int arr[] = {1, 3, 4, 9, 10};
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        /*for (int i : arr) {
            System.out.println(i);
        }*/

    }
}
