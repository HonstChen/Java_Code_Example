package com.ithema.myZipStream;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipStreamDemo3 {
    public static void main(String[] args) throws IOException {
        //1.创建File对象表示要压缩的文件夹
        File src = new File("D:\\Java_Code\\untitled\\myfile\\aaa");
        //2.创建File对象表示压缩包的父级路径
        File destParent = src.getParentFile();
        /*System.out.println(destParent.getName());
        System.out.println(src.getName());*/
        //3.创建File对象表示压缩包的路径
        File dest = new File(destParent, src.getName() + ".zip");

        //4.创建压缩流来关联压缩包
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(dest));

        //5.获取src里面每一个文件，变成zipEntry对象，放入到压缩包中
        //toZip(src, zos, src.getName());
        //6.释放资源
        zos.close();
    }

    public static void toZip(File src, ZipOutputStream zos, String name) throws IOException {
        //1.进入src文件夹
        File[] files = src.listFiles();
        //2.遍历数组
        for (File file : files) {
            if (file.isFile()) {
                //3.判断
                ZipEntry entry = new ZipEntry(name + "\\" + file.getName());
                zos.putNextEntry(entry);
                FileInputStream fis = new FileInputStream(file);
                int len;
                byte[] bytes = new byte[1024 * 1024 * 5];
                while ((len = fis.read(bytes)) != -1) {
                    zos.write(bytes, 0, len);
                }
                fis.close();
                zos.closeEntry();
            } else {
                //4.判断文件夹,递归
                toZip(file, zos, name + "\\" + file.getName());
            }
        }
    }
}
