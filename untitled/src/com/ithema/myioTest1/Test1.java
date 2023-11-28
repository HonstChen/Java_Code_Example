package com.ithema.myioTest1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1 {
    public static void main(String[] args) throws IOException {
        //1.定义变量来纪录网址
        String faimilyNameNet = "https://hanyu.baidu.com/shici/detail?pid=0b2f26d4c0ddb3ee693fdb1137ee1b0d&from=kg0";
        String boyNameNet = "http://www.haoming8.cn/baobao/10881.html";
        String girlNameNet = "http://www.haoming8.cn/baobao/7641.html";

        //2.爬取数据，把网址上所有的数据拼接成一个字符串
        String faimilyNameStr = webCrawler(faimilyNameNet);
        String boyNameStr = webCrawler(boyNameNet);
        String girlNameStr = webCrawler(girlNameNet);
        //3.通过正则表达式，把其中符合要求的数据获取出来
        ArrayList<String> failNameTempList = getData(faimilyNameStr, "([\\u4e00-\\u9fa5]{4})(，|。)", 1);
        ArrayList<String> boyNameTempList = getData(boyNameStr, "([\\u4e00-\\u9fa5]{2})(、|。)", 1);
        ArrayList<String> girlNameTempList = getData(girlNameStr, "(.. ){4}..", 0);
        ArrayList<String> failNameList = new ArrayList<>();
        for (String s : failNameTempList) {
            for (int i = 0; i < s.length(); i++) {
                failNameList.add(s.charAt(i)+"");
            }
        }
        ArrayList<String> boyNameList = new ArrayList<>(boyNameTempList);
        ArrayList<String> girlNameList = new ArrayList<>();
        for (String s : girlNameTempList) {
            String[] s1 = s.split(" ");
            for (String s2 : s1) {
                girlNameList.add(s2);
            }
        }
        //接下来随机生成名字
        ArrayList<String> info = getInfo(failNameList, boyNameList, girlNameList, 50, 70);
        /*for (String s : info) {
            System.out.println(s);
        }*/
        //写入到目录之下
        BufferedWriter bw=new BufferedWriter(new FileWriter("myfile\\aaa\\info.txt"));
        for (String s : info) {
            bw.write(s);
            bw.newLine();
        }
        bw.close();
    }

    public static ArrayList<String> getInfo(ArrayList<String> famName, ArrayList<String> boyName, ArrayList<String> girlName, int boycount, int girlcount) {
        //获取男生和女生的信息，（姓名）->性别->年龄
        HashSet<String> boyhs = new HashSet<>();
        while (true) {
            if (boyhs.size() == boycount) {
                break;
            }
            //随机
            Collections.shuffle(famName);
            Collections.shuffle(boyName);
            boyhs.add(famName.get(0) + boyName.get(0));
        }
        HashSet<String> girlhs = new HashSet<>();
        while (true) {
            if (girlhs.size() == girlcount) {
                break;
            }
            Collections.shuffle(famName);
            Collections.shuffle(girlName);
            girlhs.add(famName.get(0) + girlName.get(0));
        }
        //
        ArrayList<String> res = new ArrayList<>();
        Random random=new Random();
        for (String boy : boyhs) {
            res.add(boy+"-男-"+random.nextInt(18,27));
        }
        for (String girl : girlhs) {
            res.add(girl+"-女-"+random.nextInt(16,30));
        }
        return res;
    }

    private static ArrayList<String> getData(String str, String regex, int index) {
        //1.创建集合用来存放数据
        ArrayList<String> list = new ArrayList<>();
        //2.按照正则表达式的规则，去获取数据
        Pattern pattern = Pattern.compile(regex);
        //
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            String group = matcher.group(index);
            list.add(group);
        }
        return list;
    }


    public static String webCrawler(String net) throws IOException {
        //1.定义StringBuilder拼接爬取到的数据
        StringBuilder sb = new StringBuilder();
        //2.创建一个URL对象
        URL url = new URL(net);
        //3.连接上这个网址
        URLConnection conn = url.openConnection();
        //4.读取数据
        InputStreamReader isr = new InputStreamReader(conn.getInputStream());
        int ch;
        while ((ch = isr.read()) != -1) {
            sb.append((char) ch);
        }
        //5.释放资源
        isr.close();
        //6.把读取到的数据进行返回
        return sb.toString();
    }
}
