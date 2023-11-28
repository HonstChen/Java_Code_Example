package com.ithema.a10test4;

import java.util.UUID;

public class UUIDTest {
    public static void main(String[] args) {
        System.out.println(UUID.randomUUID());
        System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));
        //随机生成唯一的标识
        //利用随机生成的文件，可以进行名字的替换

    }
}
