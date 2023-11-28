package com.ithema.Steam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Demo1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("张三丰");
        list.add("赵敏");
        list.add("周芷若");
        //list.stream().filter(name -> name.startsWith("张")).filter(name -> name.length() == 3).forEach(name -> System.out.println(name));
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("aaa", 111);
        hm.put("bbb", 222);
        hm.put("ccc", 333);
        hm.put("ddd", 444);
        /*hm.entrySet().stream().forEach(s -> System.out.println(s));*/

        ArrayList<String> lis1 = new ArrayList<>();
        lis1.add("zhangsan,23");
        lis1.add("lisi,24");
        lis1.add("wangwu,25");
        Map<String, String> collect = lis1.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return Integer.parseInt(s.split(",")[1]) >= 24;
            }
        }).collect(Collectors.toMap(s -> s.split(",")[0], s -> s.split(",")[1]));
        collect.forEach((s, s1) -> {
            System.out.println(s + "====" + s1);
        });
        ArrayList<String> list1 = new ArrayList<>();
        Collections.addAll(list1, "张无忌", "周芷若", "赵敏");
        list1.stream().filter(s -> s.startsWith("张")).filter(s -> s.length() == 3).forEach(s -> System.out.println(s));

        list1.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.startsWith("张") && s.length() == 3;
            }
        }).forEach(s -> System.out.println(s));
        list1.stream().forEach((s -> System.out.println(s)));
    }
}
