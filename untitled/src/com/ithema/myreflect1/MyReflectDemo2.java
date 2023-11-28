package com.ithema.myreflect1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MyReflectDemo2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //获取类的构造方法
        //1.获取class字节码文件对象
        Class<?> clazz = Class.forName("com.ithema.myreflect1.Student");

        //2.获取构造方法
        Constructor<?>[] cons = clazz.getConstructors();
        //无法获取到私有的构造方法
        for (Constructor<?> con : cons) {
            System.out.println(con);
        }

        //3.获取所有的构造方法，包括私有的方法
        Constructor<?>[] delcons = clazz.getDeclaredConstructors();
        for (Constructor<?> delcon : delcons) {
            System.out.println(delcon);
        }

        //4.获取特定参数的构造方法
        Constructor<?> clazzConstructor = clazz.getConstructor(String.class,int.class);
        System.out.println(clazzConstructor);

        //setAvailable
        Constructor<?> cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Student stu = (Student) cons1.newInstance("张三");
        System.out.println(stu);
    }
}
