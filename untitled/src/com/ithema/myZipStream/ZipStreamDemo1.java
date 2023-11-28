package com.ithema.myZipStream;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipStreamDemo1 {
    public static void main(String[] args) throws IOException {
        //1.创建一个File表示要解压的压缩包
        File src = new File("myfile\\sighan.zip");
        //2.创建一个File表示要解压的目的地
        File dest = new File("myfile\\");
        unzip(src, dest);
    }

    //定义一个方法来解压
    public static void unzip(File src, File dest) throws IOException {
        //解压的本质，把压缩包里面的文件读取出来
        //创建一个解压缩流来读取压缩包中的数据
        ZipInputStream zip = new ZipInputStream(new FileInputStream(src));
        //要先获取到压缩包里面的每一个zipentry对象
        ZipEntry entry;
        while ((entry = zip.getNextEntry()) != null) {
            if (entry.isDirectory()) {
                //文件夹:需要在目的地dest处创建一个相同的文件夹
                File file = new File(dest, entry.toString());
                file.mkdirs();
            } else {
                //文件：需要读取压缩包中的文件，并且把他放到dest文件夹中（按照层级来进行存放）
                FileOutputStream fos = new FileOutputStream(new File(dest, entry.toString()));
                int b;
                while ((b = zip.read()) != -1) {
                    //写到目的地
                    fos.write(b);
                }
                fos.close();
                zip.closeEntry();
            }
        }
        zip.close();
    }
}
