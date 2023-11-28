package StudentManager;

import java.util.ArrayList;
import java.util.Scanner;

public class Mood {
    public static void addStudent(ArrayList<Student> students) {
        Student s1 = new Student();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入新增学生的名字");
        s1.setName(sc.nextLine());
        if (check(students, s1.getName()) == -1) {
            System.out.println("新增学生的ID");
            s1.setID(sc.next());
            System.out.println("请输入新增学生的地址");
            s1.setAddress(sc.next());
            System.out.println("请输入新增学生的年龄");
            s1.setAge(sc.nextInt());
            students.add(s1);
        } else {
            System.out.println("已存在重名学生！");
            return;
        }
    }

    private static int check(ArrayList<Student> students, String name) {

        for (int i = 0; i < students.size(); i++) {
            if (name.equals(students.get(i).getName())) {
                //出现重名
                return i;
            }
        }
        return -1;
    }

    public static void deleteStudent(ArrayList<Student> students) {
        System.out.println("请输入你需要删除的学生姓名:");
        Scanner sc = new Scanner(System.in);
        String r = sc.nextLine();
        int t = check(students, r);
        if (t != -1) {
            //存在该元素
            students.remove(t);
        } else {
            System.out.println("不存在该学生");
        }
    }

    public static void alterStudent(ArrayList<Student> students) {
        System.out.println("请输入你需要修改的学生的姓名:");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int t = check(students, s);
        if (t != -1) {
            Student s1 = students.get(t);
            alter(s1, choice());
            System.out.println("修改成功");
        } else {
            System.out.println("未找到该学生");
        }
    }

    private static int choice() {
        System.out.println("请输入所需修改的信息:");
        System.out.println("1.姓名");
        System.out.println("2.ID");
        System.out.println("3.年龄");
        System.out.println("4.地址");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private static void alter(Student st, int choice) {
        Scanner sc = new Scanner(System.in);
        switch (choice) {
            case 1 -> {
                System.out.println("请输入修改后的姓名");
                st.setName(sc.nextLine());
            }
            case 2 -> {
                System.out.println("请输入修改后的ID");
                st.setID(sc.nextLine());
            }
            case 3 -> {
                System.out.println("请输入修改后的年龄");
                st.setAge(sc.nextInt());
            }
            case 4 -> {
                System.out.println("请输入修改后的地址");
                st.setAddress(sc.nextLine());
            }
            default -> {
            }
        }
    }


    public static Student serachStudent(ArrayList<Student> students) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生的名字:");
        String temp = sc.nextLine();
        int t = check(students, temp);
        if (t != -1) {
            System.out.println("名字:" + students.get(t).getName());
            System.out.println("ID:" + students.get(t).getID());
            System.out.println("年龄:" + students.get(t).getAge());
            System.out.println("地址:" + students.get(t).getAddress());
            return students.get(t);
        } else return null;
    }

}
