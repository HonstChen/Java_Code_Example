package User;

public class User {
    private String name;
    private String id_number;
    private int age;
    private String class_id;

    public User() {
    }

    public User(String name, String id_number, int age, String class_id) {
        this.name = name;
        this.id_number = id_number;
        this.age = age;
        this.class_id = class_id;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return id_number
     */
    public String getId_number() {
        return id_number;
    }

    /**
     * 设置
     * @param id_number
     */
    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 获取
     * @return class_id
     */
    public String getClass_id() {
        return class_id;
    }

    /**
     * 设置
     * @param class_id
     */
    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public String toString() {
        return "User{name = " + name + ", id_number = " + id_number + ", age = " + age + ", class_id = " + class_id + "}";
    }
}
