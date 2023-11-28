package demo3;

public class Test {
    public static void main(String[] args) {
        Outer.Inner oi = new Outer.Inner();
        oi.show1();
        oi.show2();

        Outer.Inner.show2();
    }
}
