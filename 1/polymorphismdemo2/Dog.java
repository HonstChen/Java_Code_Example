package polymorphismdemo2;

public class Dog extends Animal {
    @Override
    public void eat(String something) {
        System.out.println(getAge() + "的" + getColor() + "狗吃" + something);
    }

    public Dog() {
    }

    public Dog(String color, int age) {
        super(color, age);
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    public void setColor(String color) {
        super.setColor(color);
    }

    @Override
    public int getAge() {
        return super.getAge();
    }

    @Override
    public void setAge(int age) {
        super.setAge(age);
    }

    public void lookHome() {
        System.out.println("狗看家");
    }
}
