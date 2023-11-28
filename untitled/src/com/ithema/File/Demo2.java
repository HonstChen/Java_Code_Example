package com.ithema.File;

import java.io.File;
import java.io.IOException;

public class Demo2 {
    public static void main(String[] args) throws IOException {

        //1.创建a.txt的父级路径
        File file = new File("myfile\\aaa");
        //创建父级路径
        //aaa存在，此时创建失败
        //aaa不存在，此时创建成功
        file.mkdirs();

        File src = new File(file,"a.txt");
        boolean b = src.createNewFile();
        if (b) {
            System.out.println("创建成功");
        } else {
            System.out.println("创建失败");
        }
    }
}
