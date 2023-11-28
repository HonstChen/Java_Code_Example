package Code;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test2 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        Set<Integer> set = new HashSet<>();
        while (true) {
            int t = sc.nextInt();
            if (set.add(t) == false) {
                System.out.println("已出现过该元素");
            } else {
                set.add(t);
            }
        }

    }
}
