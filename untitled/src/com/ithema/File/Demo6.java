package com.ithema.File;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo6 {
    public static void main(String[] args) throws IOException {
        //1.创建对象，写出一段文字到本地文件当中
        //可以在创建的时候，使用续写开关，打开续写开关之后，文件不会换行
        FileOutputStream fos = new FileOutputStream("myfile\\aaa\\a.txt", true);
        //2.写出数据
        fos.write("\n".getBytes());
        fos.write(97);
        fos.write("\n".getBytes());
        String str = "cdefaf";
        byte[] bytes = str.getBytes();
        //换行写：
        //再次写出一个换行符即可，Java在底层可以补全换行代码

        fos.write(bytes);
        //3.释放资源
        fos.close();
    }
}
