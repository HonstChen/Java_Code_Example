package com.ithema.File;

import java.io.*;

public class Demo12 {
    public static void main(String[] args) throws IOException {
        //拷贝文件夹，考虑子文件夹
        //1.创建对象
        /*FileInputStream fis = new FileInputStream("D:\\Test");
        FileOutputStream fos = new FileOutputStream("myfile\\");*/
        File src = new File("D:\\\\Test");
        //2.创建对象，表示目的地
        File dest = new File("myfile\\");
        //3.调用方法，开始拷贝
        copydir(src, dest);
    }

    public static void copydir(File src, File dest) throws IOException {
        //1.递归2.进入数据源3.遍历数组
        dest.mkdirs();
        File[] files = src.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                //判断文件，拷贝
                FileInputStream fis = new FileInputStream(file);
                FileOutputStream fos = new FileOutputStream(new File(dest, file.getName()));
                byte[] bytes = new byte[1024 * 2024 * 5];
                int len;
                while ((len = fis.read()) != -1) {
                    fos.write(bytes, 0, len);
                }
                fos.close();
                fis.close();
            } else {
                //4.判断文件夹，递归
                copydir(file, new File(dest, file.getName()));
            }
        }

    }
}
