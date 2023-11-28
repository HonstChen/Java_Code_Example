package polymorphismdemo2;

public class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public  void keepPet(Animal a, String something) {
        if (a instanceof Dog dog) {
            System.out.println("年龄为" + age + "的" + name + "养了一只" + a.getColor() + "的狗");
            dog.eat(something);
        } else if (a instanceof Cat cat) {
            System.out.println("年龄为" + age + "的" + name + "养了一只" + a.getColor() + "的狗");
            cat.eat(something);
        }
    }
}
