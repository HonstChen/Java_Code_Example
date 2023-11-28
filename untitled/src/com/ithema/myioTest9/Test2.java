package com.ithema.myioTest9;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Test2 {
    public static void main(String[] args) throws IOException {
        //1.创建集合
        Properties prop=new Properties();

        //2.添加数据
        prop.put("aaa","bbb");
        prop.put("bbb","ccc");
        prop.put("ddd","eee");
        prop.put("fff","iii");

        //3.把集合中的数据以键值对的形式来写到本地文件当中
        FileOutputStream fos=new FileOutputStream("myfile\\aaa\\a.properties");
        prop.store(fos,"test");
        fos.close();
    }
}
