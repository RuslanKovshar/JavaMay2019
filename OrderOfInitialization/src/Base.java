public class Base {
    protected int x = 10;

    Base() {
        System.out.println("Base constr");
        show();
    }

    void show() {
        System.out.println("Base Show " + x + " ");
    }
}