package itheima.test1;

public class User {
    private String username;
    private String password;
    private String emial;
    private String gender;
    private int age;

    public User() {

    }

    public User(String username, String password, String emial, String gender, int age) {
        this.username = username;
        this.password = password;
        this.emial = emial;
        this.gender = gender;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmial() {
        return emial;
    }

    public void setEmial(String emial) {
        this.emial = emial;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", emial='" + emial + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }
}
