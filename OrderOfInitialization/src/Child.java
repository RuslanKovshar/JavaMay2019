public class Child extends Base {

    private Child() {
        x = 20;
        System.out.println("Child constr");
        show();
    }

    @Override
    void show() {
        System.out.println("Child Show " + x + " ");
    }

    public static void main(String[] args) {
        new Child();
    }
}