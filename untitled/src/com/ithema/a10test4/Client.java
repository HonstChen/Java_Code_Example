package com.ithema.a10test4;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        //客户端：将本地文件上传到服务器，接收服务器的反馈
        //服务器：接收客户端上传的文件，上传完毕之后给出反馈

        //1.创建Socket对象
        Socket socket=new Socket("127.0.0.1",9999);

        //2.创建字节输出流
        BufferedInputStream bis=new BufferedInputStream(new FileInputStream("D:\\Java_Code\\untitled\\myfile\\aaa\\copy.mp4"));
        BufferedOutputStream bos=new BufferedOutputStream(socket.getOutputStream());
        byte[] bytes=new byte[1024];
        int len;
        while ((len=bis.read(bytes))!=-1){
            bos.write(bytes,0,len);
        }
        bos.flush();
        socket.shutdownOutput();

        //接收服务器的回写数据
        BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String b=br.readLine();
        System.out.println(b);

        //4.释放资源
        socket.close();

    }
}
