package com.ithema.File;

import java.io.File;

public class Demo3 {
    public static void main(String[] args) {
        //定义一个方法，查找是否有avi结尾的电影
        File file = new File("D:\\iTunes");
        boolean b = haveAVI(file);
        System.out.println(b);
    }

    //寻找某个文件夹中，是否有以avi结尾的电源
    public static boolean haveAVI(File file) {
        //进入aaa文件夹，而且要获取里面所有的内容
        File[] files = file.listFiles();
        //2.遍历数组，获取里面的每一个元素
        for (File f : files) {
            if (f.isFile() && f.getName().endsWith(".avi")) {
                return true;
            }
        }
        return false;
    }
}
