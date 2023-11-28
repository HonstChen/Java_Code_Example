package com.ithema.myioTest9;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class Test3 {
    public static void main(String[] args) throws IOException {
        //1.创建集合
        Properties prop = new Properties();

        //2.读取本地Properties文件里面的数据
        FileInputStream fis = new FileInputStream("myfile\\aaa\\a.properties");
        prop.load(fis);

        //遍历集合
        Set<Object> keySet = prop.keySet();
        for (Object key : keySet) {
            Object value = prop.get(key);
            System.out.println(key+"="+value);
        }

    }
}
