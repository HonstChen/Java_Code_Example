package polymorphismdemo2;

public class Cat extends Animal {
    @Override
    public void eat(String something) {
        System.out.println(getAge() + "的" + getColor() + "猫吃" + something);
    }

    public Cat() {
    }

    public Cat(String color, int age) {
        super(color, age);
    }

    public void catchMouse() {
        System.out.println("猫抓老鼠");
    }
}
