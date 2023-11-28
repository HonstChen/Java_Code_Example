package CustManager;

public class Cust {
    private String name;
    private int ID;
    private String PWD;
    private int money;
    static String bankName = "建设银行";
    private int selfNum = 0;
    static int allNum = 0;

    Cust() {

    }

    public Cust(String name, int ID, String PWD, int money) {
        this.name = name;
        this.ID = ID;
        this.PWD = PWD;
        this.money = money;
        allNum++;
        selfNum = allNum;
    }

    void getMoney() {
        System.out.println("请输入要取出的金额:");
        int n = Integer.parseInt(KB.scan());
        this.money -= n;
    }

    void saveMoney() {
        System.out.println("请输入要存储的金额:");
        int n = Integer.parseInt(KB.scan());
        this.money += n;
    }

    void search() {
        System.out.println("所属银行:" + Cust.bankName);
        System.out.println("您是本银行" + allNum + "个顾客中的第" + selfNum + "个顾客");
        System.out.println("户名" + this.name);
        System.out.println("账号" + this.ID);
        System.out.println("账户余额:" + this.money);
    }

    void changePWD() {
        System.out.println("请输入用户密码:");
        String p = KB.scan();
        this.PWD = p;
    }

    int getID() {
        return this.ID;
    }
}
