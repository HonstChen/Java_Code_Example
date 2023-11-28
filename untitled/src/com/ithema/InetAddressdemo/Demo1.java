package com.ithema.InetAddressdemo;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Demo1 {
    public static void main(String[] args) throws UnknownHostException {

        //1.获取InetAddress的对象
        //IP的对象，一台电脑的对象
        InetAddress address = InetAddress.getByName("LAPTOP-T9SJQK1E");
        System.out.println(address);

        String name=address.getHostName();
        System.out.println(name);
        String hostAddress = address.getHostAddress();
        System.out.println(hostAddress);

    }
}
