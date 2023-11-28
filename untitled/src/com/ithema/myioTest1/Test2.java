package com.ithema.myioTest1;

import cn.hutool.core.util.ReUtil;
import cn.hutool.http.HttpUtil;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        //1.定义变量来纪录网址
        String faimilyNameNet = "https://hanyu.baidu.com/shici/detail?pid=0b2f26d4c0ddb3ee693fdb1137ee1b0d&from=kg0";
        String boyNameNet = "http://www.haoming8.cn/baobao/10881.html";
        String girlNameNet = "http://www.haoming8.cn/baobao/7641.html";

        //2.爬取数据，把网址上所有的数据拼接成一个字符串
        String faimilyNameStr = HttpUtil.get(faimilyNameNet);
        String boyNameStr = HttpUtil.get(boyNameNet);
        String girlNameStr = HttpUtil.get(girlNameNet);

        //3.正则表达式进行获取数据
        //3.通过正则表达式，把其中符合要求的数据获取出来
        List<String> failNameTempList = ReUtil.findAll("([\\u4e00-\\u9fa5]{4})(，|。)", faimilyNameStr, 1);
        List<String> boyNameTempList = ReUtil.findAll("([\\u4e00-\\u9fa5]{2})(、|。)", boyNameStr, 1);
        List<String> girlNameTempList = ReUtil.findAll("(.. ){4}..", girlNameStr, 0);

        /*System.out.println(failNameTempList);
        System.out.println(boyNameTempList);
        System.out.println(girlNameTempList);*/
        //4.处理数据
        //调用Test1的代码即可
        //5.生成数据

        //6.打印流，写出数据

    }
}
