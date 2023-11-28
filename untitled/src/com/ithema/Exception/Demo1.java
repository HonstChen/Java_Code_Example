package com.ithema.Exception;

public class Demo1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        try {
            System.out.println(arr[10]);
            System.out.println(2 / 0);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            String message = e.getMessage();
            System.out.println(message);
        } catch (ArithmeticException e) {
            System.out.println("除数不能为0");
        }//存在父子关系的异常，父类一定要写在子类的下面，执行的时候，优先执行
        //捕捉子类
        System.out.println("我被执行了");
    }
}
