public class InsertionSorter {
    public static void sort(int[] arr){
        for (int i = 1; i < arr.length ; i++) {
            int newElement = arr[i];
            int pos = i - 1;
            while (pos >= 0 && arr[pos] > newElement){
                arr[pos + 1] = arr[pos];
                pos--;
            }
            arr[pos + 1] = newElement;
        }
    }
}
