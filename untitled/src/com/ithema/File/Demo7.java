package com.ithema.File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Demo7 {
    public static void main(String[] args) throws IOException {
        /*
         * 读取资源，创建对象，释放资源*/
        //1.创建对象
        FileInputStream fis = new FileInputStream("myfile\\aaa\\a.txt");
        //2.读取数据
        int b1 = fis.read();
        System.out.println(b1);

        //3.释放资源
        fis.close();
    }
}
