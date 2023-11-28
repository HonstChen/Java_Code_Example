package itheima.test1;

import java.util.Random;

public class Role {
    private int blood;
    private String name;

    public Role() {

    }

    public Role(int blood, String name) {
        this.blood = blood;
        this.name = name;
    }

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void attack(Role role) {
        Random r = new Random();
        int hurt = r.nextInt(20) + 1;
        int remainBoold = role.getBlood() - hurt;
        remainBoold = Math.max(remainBoold, 0);
        role.setBlood(remainBoold);
        System.out.println(this.getName() + "举起拳头，打了" + role.getName() + "一下," + "造成了" + hurt + "点伤害," + role.getName() + "还剩下" + role.getBlood() + "点血");

    }
}
