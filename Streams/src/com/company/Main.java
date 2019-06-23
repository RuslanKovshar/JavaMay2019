package com.company;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        int[] ints = {-7, 8, 5, 3, 0, -8, 0, -10, 0, 1, 2, 0};
        System.out.println(Arrays.toString(ints));

        System.out.println("Find the average value of the elements of the array:");
        double average = IntStream.of(ints).summaryStatistics().getAverage();
        double avg = IntStream.of(ints).average().getAsDouble();
        System.out.println("Average: " + average);
        System.out.println("Average: " + avg);

        System.out.println("Find the minimum element, value and index: ");
        int min = IntStream.of(ints).min().getAsInt();
        long index = IntStream.of(ints).takeWhile(x -> x != min).count();
        System.out.println("Min element: " + min + "\nOn index: " + index);

        System.out.println("Count the number of elements equal to zero: ");
        System.out.println(IntStream.of(ints).filter(x -> x == 0).count());


        System.out.println("Count the number of elements greater than zero: ");
        System.out.println(IntStream.of(ints).filter(x -> x > 0).count());

        System.out.println("Multiply array elements by number: ");
        int[] ints1 = IntStream.of(ints).map(x -> x * 3).toArray();
        System.out.println(Arrays.toString(ints1));
    }
}