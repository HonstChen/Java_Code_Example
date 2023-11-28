package CustManager;

import static CustManager.Menu.choice;
import static CustManager.Menu.showMenu;

public class Demo {
    public static void main(String[] args) {
        Cust st = new Cust("Tom", 100, "12345", 10000);
        System.out.println("请输入您的ID");
        int ID = Integer.parseInt(KB.scan());
        if (ID == st.getID()) {
            while (true) {
                showMenu();
                int key = Integer.parseInt(KB.scan());
                choice(key, st);
            }
        } else {
            System.out.println("您的ID有误!");
        }
    }
}
