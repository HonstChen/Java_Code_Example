package polymorphismdemo2;

public class Student {
    private String name;
    private int age;

    {
        System.out.println("对象创建中");
    }

    public Student() {
        this(null, 0);
    }

    static {
        System.out.println("静态代码块执行");
    }

    public Student(String name, int age) {
        System.out.println("有参构造");
        this.name = name;
        this.age = age;
    }
}
