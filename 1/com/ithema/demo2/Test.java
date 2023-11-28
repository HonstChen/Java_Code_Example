package com.ithema.demo2;

import com.ithema.demo.Frog;

public class Test {
    public static void main(String[] args) {
        //创建对象
        Frog f = new Frog("小青", 1);
        f.eat();


        Rabbit r = new Rabbit("小白", 2);
        System.out.println(r.getName() + ", " + r.getAge());
        r.eat();
    }
}
