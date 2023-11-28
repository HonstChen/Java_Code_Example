package com.ithema.Time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class DateDemo2 {
    /*
        需求1:打印时间原点开始一年之后的时间
        需求2:定义两个date对象，比较一下哪个时间在前，哪个时间在后
     */
    public static void main(String[] args) throws ParseException {
        Date d1 = new Date(0L);
        long time = d1.getTime();
        time = time + 1000L * 60 * 60 * 24 * 365;
        d1.setTime(time);
        //System.out.println(d1);

        Random r = new Random();

        //创建两个date对象
        /*Date d = new Date(Math.abs(r.nextInt()));
        Date d2 = new Date(Math.abs(r.nextInt()));
        long time1 = d.getTime();
        long time2 = d2.getTime();
        if (time1 > time2) {
            System.out.println(d);
            System.out.println("第一个时间在前");
            System.out.println(d2);
        } else {
            System.out.println(d2);
            System.out.println("第二个时间在前");
            System.out.println(d);
        }*/

        //1.利用空参构造创建simpleDateFormat对象，默认格式
        SimpleDateFormat sdf1 = new SimpleDateFormat();
        Date date = new Date(0L);
        String str1 = sdf1.format(d1);
        System.out.println(str1);
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日 HH:MM:SS EE");
        System.out.println(sdf2.format(d1));

        //定义一个字符串表示时间
        String st = "2023-11-11 11:11:11";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");
        Date parse = simpleDateFormat.parse(st);
        System.out.println(parse);

    }
}
