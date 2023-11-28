package CustManager;

public class Menu {
    public static void showMenu() {
        System.out.println("1.存款");
        System.out.println("2.取款");
        System.out.println("3.修改密码");
        System.out.println("4.查询");
        System.out.println("5.退出");
    }

    public static void choice(int key, Cust st) {
        switch (key) {
            case 1:
                st.saveMoney();
                break;
            case 2:
                st.getMoney();
                break;
            case 3:
                st.changePWD();
                break;
            case 4:
                st.search();
                break;
            case 5:
                System.exit(1);
        }
    }
}
