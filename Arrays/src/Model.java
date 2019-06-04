public class Model {

    private int[] arr = {0,1,2,3,4};

    public void first(){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length ; j++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    public void second(){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i ; j++) {
                System.out.print(arr[j] + " ");
            }
            System.out.println();
        }
    }

    public void third(){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length ; j++) {
                System.out.print(arr[j] + " ");
            }
            System.out.println();
        }
    }
}
