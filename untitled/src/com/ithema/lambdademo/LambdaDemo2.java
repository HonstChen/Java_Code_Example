package com.ithema.lambdademo;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Consumer;

public class LambdaDemo2 {
    public static void main(String[] args) {
        //利用匿名内部类的形式去调用下面的方法
        method(new Swim() {
            @Override
            public void swimning() {
                System.out.println("正在游泳");
            }
        });
        Integer[] arr = {2, 3, 1, 5, 6, 7, 8, 4, 9};
        /*Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });*/
        Arrays.sort(arr, (o1, o2) -> {
            return o1 - o2;
        });
        String[] arr1 = {"a", "aaaa", "aa", "aaa"};
        Arrays.sort(arr1, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }
        Arrays.sort(arr1, (o1, o2) -> {
            return o2.length() - o1.length();
        });
        Arrays.sort(arr1, (o1, o2) -> o1.length() - o2.length());
        System.out.println(arr1);
        LocalDate date = LocalDate.now();
        System.out.println(date);
        Collection<Integer> coll = new ArrayList<>();
        Set<String> strings = new HashSet<>();
        strings.add("张三");
        strings.add("李四");
        strings.add("王五");
        strings.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        strings.forEach((str) -> {
            System.out.println(str);
        });
        /*method(() -> {
            System.out.println("正在游泳");
        });*/
    }

    public static void method(Swim s) {
        s.swimning();
    }
}

interface Swim {
    public abstract void swimning();
}
