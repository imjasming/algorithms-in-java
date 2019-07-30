package com.xiaoming.util;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Xiaoming.
 * Created with IntelliJ IDEA on 2018/02/21 22:34.
 * Description :
 */
final public class RandomArray {
    public static int[] noDuplicateRandomArray(int n, int min, int max) {
        int range = max - min + 1;
        if (max < min || n < range){
            throw new IllegalArgumentException();
        }

        // fill an array with numbers min, min+ 1, ... max
        int[] numbers = new int[range];
        for (int i = 0; i < numbers.length; i++)
            numbers[i] = min + i;

        // draw k numbers and put them into a second array
        int[] result = new int[n];
        for (int i = 0; i < result.length; i++) {
            // make a randomWithInputNoDuplicate index between 0 and n - 1
            int r = (int) (Math.random() * range);

            // pick the element at the randomWithInputNoDuplicate location
            result[i] = numbers[r];

            // move the last element into the randomWithInputNoDuplicate location
            numbers[r] = numbers[range - 1];
            range--;
        }

        return result;
    }

    public static int[] noDuplicateRandomArray(int n, int max) {
        return noDuplicateRandomArray(n, 1, max);
    }

    public static int[] randomWithInputNoDuplicate() {
        Scanner in = new Scanner(System.in);

        System.out.print("How many numbers do you need to draw? ");
        int n = in.nextInt();

        System.out.print("What is the highest number you can draw? ");
        int max = in.nextInt();

        return noDuplicateRandomArray(n, max);
    }

    public static int[] duplicateRandomArray(int n, int min, int max) {
        int range = max - min + 1;

        // draw n numbers and put them into a second array
        int[] result = new int[n];
        for (int i = 0; i < result.length; i++) {
            // make a randomWithInputNoDuplicate index between min and max
            result[i] = (int) (Math.random() * range) + min;
        }

        return result;
    }

    public static int[] duplicateRandomArrayWithInput() {
        Scanner in = new Scanner(System.in);

        System.out.print("How many numbers do you need to draw? ");
        int k = in.nextInt();

        System.out.print("What is the highest number you can draw? ");
        int n = in.nextInt();

        return duplicateRandomArray(k, 1, n);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(noDuplicateRandomArray(10, -5, 4)));
    }
}
