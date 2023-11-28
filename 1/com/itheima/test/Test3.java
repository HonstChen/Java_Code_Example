package com.itheima.test;

import java.util.Random;

public class Test3 {
    public static void main(String[] args) {
        //随机产生一个五位的验证码
        //验证码的格式：长度为5，前四位是大写字母或者小写字母
        //最后一位是数字
        String res = getPassword();
        System.out.println(res);
    }

    //放在数组当中，用索引来进行随机抽取。
    public static String getPassword() {
        char[] chs = new char[52];
        char st1 = 'a';
        char st2 = 'A';
        for (int i = 0; i < 26; i++) {
            chs[i] = st1;
            st1++;
        }
        for (int i = 26; i < 52; i++) {
            chs[i] = st2;
            st2++;
        }
        StringBuilder res = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            int randomIndex = r.nextInt(chs.length);
            res.append(chs[randomIndex]);
        }
        res.append(r.nextInt(10));
        return res.toString();
    }
}
