package com.ithema.Regex;

import java.util.Date;

public class Demo3 {
    public static void main(String[] args) {
        String str = "我要学学变变变成成成成";
        //需求：把重复的内容替换为单个的
        //(?:)非捕获分组，不占用组号
        String regex = "(.)\\1+";
        String s = str.replaceAll("(.)\\1+", "$1");
        //System.out.println(s);
        Date d = new Date();
        System.out.println(d);
        Date d2 = new Date(0L);
        //东八区，在基础时间上加上两个小时
        System.out.println(d2);
        //1000毫秒
        d2.setTime(1000L);
        System.out.println(d2);
    }
}
