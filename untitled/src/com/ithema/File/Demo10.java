package com.ithema.File;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Demo10 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "ai你哟";
        //1.编码
        byte[] bytes1 = str.getBytes();
        System.out.println(Arrays.toString(bytes1));

        byte[] bytes2 = str.getBytes("GBK");
        System.out.println(Arrays.toString(bytes2));

        //2.解码
        String str2 = new String(bytes1);
        System.out.println(str2);

        String str3 = new String(bytes1, "GBK");
        System.out.println(str3);
        //编码与解码的方式不一样的话，会存在乱码
        //读取数据时候未完整读取整个汉字;编码与解码的方式不一样


    }
}
