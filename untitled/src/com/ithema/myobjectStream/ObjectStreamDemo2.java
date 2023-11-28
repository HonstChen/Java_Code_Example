package com.ithema.myobjectStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ObjectStreamDemo2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //1.创建反序列化流的对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("myfile\\aaa\\object.txt"));

        //2.读取数据
        Object o = ois.readObject();
        ArrayList<Student> list = new ArrayList<>();
        //3.打印对象
        list = (ArrayList<Student>) o;
        //list已经被序列化
        for (Student student : list) {
            System.out.println(student);
        }
        //4.释放资源
        ois.close();
    }
}
