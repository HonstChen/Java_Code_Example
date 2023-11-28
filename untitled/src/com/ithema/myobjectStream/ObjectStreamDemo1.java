package com.ithema.myobjectStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ObjectStreamDemo1 {
    public static void main(String[] args) throws IOException {
        //1.创建对象
        Student stu1 = new Student("zhangsan", 23);
        Student stu2 = new Student("Lisi", 25);
        Student stu3 = new Student("wangwu", 27);
        Student stu4 = new Student("wuli", 19);
        ArrayList<Student> list = new ArrayList<>();
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);
        list.add(stu4);
        //2.创建序列化流的对象/对象操作输出流
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("myfile\\aaa\\object.txt"));

        //3.写出数据
        oos.writeObject(list);

        //4.释放资源
        oos.close();
    }
}
