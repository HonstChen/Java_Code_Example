package polymorphismdemo1;

public class Cat extends Animal {
    @Override
    public void eat() {
        System.out.println("猫吃小鱼干");
    }

    public Cat() {
    }

    public Cat(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    public void catchMouse() {
        System.out.println("猫抓老鼠");
    }
}
