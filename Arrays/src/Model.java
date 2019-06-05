public class Model {

    private int[] arr = {0,1,2,3,4};

    /*
    * дан масив {0,1,2,3,4}
    * вывод в виде
    * 0 0 0 0 0
    * 1 1 1 1
    * 2 2 2
    * 3 3
    * 4 */
    public void first(){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length ; j++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    /*
     * дан масив {0,1,2,3,4}
     * вывод в виде
     * 0 1 2 3 4
     * 0 1 2 3
     * 0 1 2
     * 0 1
     * 0 */
    public void second(){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i ; j++) {
                System.out.print(arr[j] + " ");
            }
            System.out.println();
        }
    }


    /*
     * дан масив {0,1,2,3,4}
     * вывод в виде
     * 0 1 2 3 4
     * 1 2 3 4
     * 2 3 4
     * 3 4
     * 4 */
    public void third(){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length ; j++) {
                System.out.print(arr[j] + " ");
            }
            System.out.println();
        }
    }
}
