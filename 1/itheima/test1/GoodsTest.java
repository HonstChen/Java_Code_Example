package itheima.test1;

import java.util.Scanner;
import java.util.StringJoiner;

public class GoodsTest {
    public static void main(String[] args) {
        StringBuilder res = new StringBuilder("aaabbbccc");
        //System.out.println(res.substring(1).replace('b', 'Q'));
        res.append("hhh");
        //System.out.println(res);
        //反转键盘录入的字符串
        //Scanner sc = new Scanner(System.in);
        //String str = sc.nextLine();
        //String re = new StringBuilder().append(str).reverse().toString();
        //System.out.println(str.equals(re));
//        int[] arr = {1, 2, 3};
//        String str1 = arrToSrting(arr);
//        System.out.println(str1);
//        StringJoiner sj = new StringJoiner("---");
//        for (int i = 0; i < arr.length; i++) {
//            sj.add("a");
//        }
//        System.out.println(sj);
        String s1 = "abc";
        String s2 = "ab";
        String s3 = s2 + "c";
        System.out.println(s1.equals(s3));
        String s = "abc";
        String s4 = "a" + "b" + "c";
        System.out.println(s2 == s3);
        System.out.println(s == s4);
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.capacity());
    }

    public static String arrToSrting(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                sb.append(arr[i]);
            } else {
                sb.append(arr[i]).append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
