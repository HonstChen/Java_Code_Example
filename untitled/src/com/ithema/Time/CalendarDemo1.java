package com.ithema.Time;

import java.util.Calendar;
import java.util.Date;

public class CalendarDemo1 {
    public static void main(String[] args) {
        //1.获取日历对象，Calendar是一个抽象类，不能直接new，而是通过一个静态方法获取到子类对象
        Calendar c = Calendar.getInstance();
        //根据系统的不同时区来获取不同的日历对象
        //会把时间中的纪元。等放到一个数组当中
        //细节2：月份包含0到11，获取出来的是1，实际上是二月
        System.out.println(c);

        //2.修改一下日历的时间
        Date d = new Date(0L);
        c.setTime(d);
        System.out.println(c);

        //get获取日期中某个字段的信息
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int date = c.get(Calendar.DATE);
        int week = c.get(Calendar.DAY_OF_WEEK);
        System.out.println(year + ", " + month + ", " + date + ", " + week);
        c.set(Calendar.YEAR, 2000);
        c.set(Calendar.MONTH, 11);
        System.out.println(c.get(Calendar.YEAR) + ", " + c.get(Calendar.MONTH) + " ");
        c.add(Calendar.YEAR, 1);
        System.out.println(c.get(Calendar.YEAR) + ", " + c.get(Calendar.MONTH) + " ");
    }
}
