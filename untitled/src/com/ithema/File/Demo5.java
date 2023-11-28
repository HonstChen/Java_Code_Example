package com.ithema.File;

import java.io.File;

public class Demo5 {
    public static void main(String[] args) {
        /*
         * 删除一个多级文件夹
         * 1.先删除文件夹里面的所有内容
         * 2.再删除自己
         * */
        File file = new File("D:\\test");
        delete(file);
    }

    public static void delete(File src) {
        //1.先删除文件夹里面所有的内容
        //进入src，遍历，判断，判断
        File[] files = src.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    //如果是文件，则进行删除
                    file.delete();
                } else {
                    //递归,删除目录下其他的文件夹
                    delete(file);
                }
            }
        } else {
            System.out.println("没有该文件夹");
        }
        //2.在删除自己
        src.delete();
    }
}
