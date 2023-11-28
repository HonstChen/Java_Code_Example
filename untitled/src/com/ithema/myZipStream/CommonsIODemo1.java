package com.ithema.myZipStream;

import cn.hutool.core.io.FileUtil;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class CommonsIODemo1 {
    public static void main(String[] args) throws IOException {
        File src=new File("myfile\\aaa\\a.txt");
        File dest=new File("myfile\\aaa\\copyy.txt");
        FileUtils.copyFile(src,dest);

        File file=FileUtil.file("D:\\","aaa","bbb","a.txt");
        System.out.println(file);

        File touch=FileUtil.touch(file);
        System.out.println(touch);
    }
}
