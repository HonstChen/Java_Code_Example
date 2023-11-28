package com.ithema.myZipStream;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipStreamDemo2 {
    public static void main(String[] args) throws IOException {
        //将a.txt打包成为一个压缩包
        //1.创建File对象来表示要压缩的文件
        File src = new File("myfile\\aaa\\a.txt");
        //2.创建File对象来表示压缩包的位置
        File dest = new File("myfile\\");
        //3.调用方法来压缩
        toZip(src, dest);
    }

    public static void toZip(File src, File dest) throws IOException {
        //1.创建压缩流来关联压缩文件
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(new File(dest, "a.zip")));

        //2.创建ZipEntry对象，表示压缩包里面的每一个文件和文件夹
        ZipEntry entry = new ZipEntry("a.txt");
        //3.把Zip对象放到压缩包当中
        zos.putNextEntry(entry);
        FileInputStream fis = new FileInputStream(src);
        int b;
        while ((b = fis.read()) != -1) {
            zos.write(b);
        }
        zos.closeEntry();
        zos.close();
    }
}
