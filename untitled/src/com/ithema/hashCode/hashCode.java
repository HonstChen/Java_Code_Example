package com.ithema.hashCode;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class hashCode {
    public static void main(String[] args) {

        TreeSet<Integer> tr = new TreeSet<>();
        tr.add(1);
        tr.add(3);
        tr.add(2);
        tr.add(5);
        tr.add(4);
       /* Iterator<Integer> it = tr.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        for (Integer integer : tr) {
            System.out.println(integer);
        }
        tr.forEach((o) -> {
            System.out.println(o);
        });*/
        TreeSet<Student> trs = new TreeSet<>();
        Student s1 = new Student("zhangsan", 23);
        Student s2 = new Student("lisi", 20);
        Student s3 = new Student("wangwu", 37);
        trs.add(s1);
        trs.add(s2);
        trs.add(s3);
        /*for (Student student : trs) {
            System.out.println(student.toString());
        }*/
        Map<String, String> map = new HashMap<>();
        map.put("小龙女", "郭靖");
        map.put("aaa", "bbb");
        /*map.forEach((o, o1) -> {
            System.out.println(o1);
        });*/
        Set<String> keys = map.keySet();
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "=" + value);
        }
        map.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String s, String s2) {
                System.out.println(s);
                System.out.println(s2);
            }
        });
        String regex = "\\b\\w+\\b";
        String text = "This student is studious";
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(text);
        while (matcher.find()) {
            String word = matcher.group();
            System.out.println(word);
        }
        TreeMap<String, Integer> treeMap = new TreeMap<>();

        /*keys.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(map.get(s));
            }
        });
        map.forEach((o1, o2) -> {
            if (o1.equals("小龙女")) {
                System.out.println(o2);
            }
        });*/
        /*System.out.println(map.put("小龙女", "c"));
        System.out.println(map.put("da", "gg"));
        System.out.println(map);
        System.out.println(2147483647 % (1e9 + 7));*/
    }
}
