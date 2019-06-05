import java.util.Arrays;

public class SelectionSorterTest {
    public static void main(String[] main){
        int[][] arrays = {{},{1},{5,4},{6,9,1,0},{5,6,1,0,3},{0,9,5,2,7,8,4,3}};

        for (int[] arr:arrays) {
            System.out.print(Arrays.toString(arr) + "--->");
            SelectionSorter.sort(arr);
            System.out.println(Arrays.toString(arr));
        }
    }
}