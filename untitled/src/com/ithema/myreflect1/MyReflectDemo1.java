package com.ithema.myreflect1;

public class MyReflectDemo1 {
    public static void main(String[] args) throws ClassNotFoundException {

        //1.第一种方式
        //全类名:包名＋类名
        //最为常用
        Class clazz = Class.forName("com.ithema.myreflect1.Student");
        System.out.println(clazz);

        //2.第二种方法
        //一般更多的是当作参数进行使用
        Class<Student> claszz2 = Student.class;

        System.out.println(claszz2);
        System.out.println(claszz2.equals(clazz));

        //3.第三种方式
        //当我们已经有了类对象的时候才使用这个方法
        Student s=new Student();
        Class<? extends Student> clazz3 = s.getClass();
        System.out.println(clazz3);
    }
}
