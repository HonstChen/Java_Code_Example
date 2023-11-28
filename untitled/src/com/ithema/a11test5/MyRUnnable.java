package com.ithema.a11test5;

import java.io.*;
import java.net.Socket;
import java.util.UUID;

public class MyRUnnable implements Runnable{
    Socket socket;
    public MyRUnnable(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run() {
        try {
            //创建字节输入输出流等
            BufferedInputStream bis=new BufferedInputStream(socket.getInputStream());
            String name= UUID.randomUUID().toString().replace("-","");
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:\\Java_Code\\untitled\\myfile\\ccc\\"+name+".mp4"));
            int len;
            byte[] bytes=new byte[1024];
            while ((len=bis.read(bytes))!=-1){
                bos.write(bytes,0,len);
            }
            bos.close();
            //4.回写数据
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write("上传成功");
            bw.newLine();
            bw.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //5.释放资源
            if (socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
