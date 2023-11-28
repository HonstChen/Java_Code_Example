package com.ithema.myioTest9;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Test1 {
    public static void main(String[] args) {
        //1.创建集合对象
        Properties prop = new Properties();

        //2.添加数据
        //细节：可以添加任意数据类型的数据，但一般只会添加字符串类型的数据
        prop.put("aaa","bbb");
        prop.put("bbb","222");
        prop.put("ccc","333");
        prop.put("ddd","444");
        //底层原理是Map
        System.out.println(prop);
        Set<Object> keySet = prop.keySet();
        for (Object key : keySet) {
            Object value = prop.get(key);
            System.out.println(key+"="+value);
        }
        Set<Map.Entry<Object, Object>> entries = prop.entrySet();

    }
}
