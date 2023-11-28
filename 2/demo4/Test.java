package demo4;

public class Test {
    public static void main(String[] args) {
        new Animal() {
            @Override
            public void eat() {
                System.out.println("重写了eat方法");
            }
        };
        method(new Animal() {
            @Override
            public void eat() {
                System.out.println("狗吃骨头");
            }
        });
        Swim s = new Swim() {
            @Override
            public void swim() {
                System.out.println("重写了游泳的方法");
            }
        };
        s.swim();
        new Swim() {
            @Override
            public void swim() {
                System.out.println("重写额");
            }
        }.swim();
    }


    public static void method(Animal a) {
        a.eat();
    }
}
