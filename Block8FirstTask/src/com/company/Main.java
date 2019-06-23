package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(4, 5, -6, 4, 5, 3, 4, 2, 4, 5, 7));

        TreeMap<Integer, Integer> nums = new TreeMap<>();
        Integer count;
        for (Integer number : numbers) {
            count = nums.get(number);
            if (count == null) {
                count = 0;
            }
            nums.put(number, count + 1);
        }

        for (Map.Entry<Integer, Integer> item : nums.entrySet()) {
            System.out.printf("Key: %d  Value: %s\n", item.getKey(), item.getValue());
        }
    }
}
