package polymorphismdemo1;

public class Test {
    public static void main(String[] args) {
//        Student s = new Student();
//        s.setName("张三");
//        s.setAge(30);
//
//        Teacher t = new Teacher();
//        t.setAge(50);
//        t.setName("李四");
//        Administrator a = new Administrator();
//        a.setAge(45);
//        a.setName("厉害");
//
//        register(s);
//        register(t);
//        register(a);
        Animal a = new Dog();
        a.eat();
        Animal b = new Cat();
        b.eat();
        Cat c = (Cat) b;
        if (a instanceof Dog d) {
            d.lookHome();
        } else if (a instanceof Cat g) {
            g.catchMouse();
        } else {
            System.out.println("没有这个类型");
        }
    }

    public static void register(Person p) {
        p.show();
    }

}
