package LeetCode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String regex1 = "1[3-9]\\d{9}";
        //System.out.println("13617895426".matches(regex1));
        String regex2 = "0\\d{2,3}-?[1-9]\\d{4,9}";
        //System.out.println("020-2324242".matches(regex2));

        //(?i)忽略大小写(?=)占位符
        //?:获取整体的东西
        //!去除
        //+:贪婪爬取
        //+?:非贪婪爬取
        String text = "JAva自从95年问世以来，经历了很多版本，目前企业中使用最多的是JaVa8和Java11";
        Pattern p = Pattern.compile("(?i)Java(?=8|11)");
        Pattern q = Pattern.compile("(?i)Java(?:8|11)");
        Pattern r = Pattern.compile("(?i)Java(!8|11)");
        Matcher m = r.matcher(text);
        /*while (m.find()) {
            System.out.println(m.group());
        }*/

        String s = "小诗诗adsabdsadjsaj小丹丹asidjjdfja小慧慧";
        String res1 = s.replaceAll("[\\w&&[^_]]+", "vs");
        //System.out.println(res1);

        String[] split = s.split("[\\w&&[^_]]+");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }
    }
}
