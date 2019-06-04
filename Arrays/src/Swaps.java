import java.util.Arrays;

public class Swaps {
    public static void main(String[] args) {
        int[] array = {5, 1, 3, 4, 0, 8, 9, 7, 6, 2};
        int[] temp_array = {5, 1, 3, 4, 0, 8, 9, 7, 6, 2};

        System.out.println("Conditional swap!");
        System.out.println(Arrays.toString(array));
        for (int k = 0; k < array.length - 1; k++) {
            conditionalSwap(array, k, k + 1);
        }
        System.out.println(Arrays.toString(array));

        System.out.println("Unconditional swap!");
        System.out.println(Arrays.toString(temp_array));
        for (int k = 0; k < temp_array.length - 1; k++) {
            unconditionalSwap(temp_array, k, k + 1);
        }
        System.out.println(Arrays.toString(temp_array));
    }

    public static void conditionalSwap(int[] array, int fst, int snd) {
        if (array[fst] > array[snd]) {
            int tmp = array[fst];
            array[fst] = array[snd];
            array[snd] = tmp;
        }
    }

    public static void unconditionalSwap(int[] array, int fst, int snd) {
        int tmp = array[fst];
        array[fst] = array[snd];
        array[snd] = tmp;
    }
}
