package com.itheima.test;

public class Test14 {
    class Animal {
        public void drink() {
            System.out.println("喝水");
        }

        public void eat() {
            System.out.println("吃饭");
        }
    }

    class Cat extends Animal {
        private String name;

        public void catchMouse() {
            System.out.println("抓老鼠");
        }
    }

    class Dog extends Animal {
    }
}
