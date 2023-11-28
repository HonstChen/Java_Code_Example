package StudentManager;

import java.util.ArrayList;
import java.util.Scanner;

import static StudentManager.Mood.*;
import static StudentManager.Menu.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            showMenu();
            int key = sc.nextInt();
            switch (key) {
                case 1 -> {
                    addStudent(list);
                }
                case 2 -> {
                    deleteStudent(list);
                }
                case 3 -> {
                    alterStudent(list);
                }
                case 4 -> {
                    serachStudent(list);
                }
                case 5 -> {
                    System.exit(1);
                }
            }
        }
    }
}
