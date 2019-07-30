package com.xiaoming.sort;

import com.xiaoming.util.RandomArray;

import java.util.Arrays;
import java.util.Date;

import static com.xiaoming.sort.InsertionSort.insertionSort0;

/**
 * @author Xiaoming.
 * Created with IntelliJ IDEA on 2018/02/20 21:50.
 * Description :
 */
public class SelectionSort {

    @SuppressWarnings("unchecked")
    private static void selectionSort0(Integer[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = a[i];
            int key = i;

            int j = i + 1;
            while (j < a.length) {
                if (a[j] < min) {
                    min = a[j];
                    key = j;
                }
                j++;
            }

            min = a[i];
            a[i] = a[key];
            a[key] = min;
        }
    }

    static void selectionSort0(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int key = i;
            int j = i + 1;
            while (j < a.length) {
                if (a[j] < a[key]) {
                    key = j;
                }
                j++;
            }
            int temp = a[i];
            a[i] = a[key];
            a[key] = temp;
        }
    }

    public static void selectionSort(int[] a) {
        if (a == null) {
            throw new NullPointerException();
        }
        selectionSort0(a);
    }


    public static void main(String[] args) {
        int[] result = RandomArray.randomWithInputNoDuplicate();

        int[] result1 = result.clone();
        int[] result2 = result.clone();

        System.out.println("Before sorted: " + Arrays.toString(result));
        long t0 = new Date().getTime();

        long t1 = new Date().getTime();
        insertionSort0(result1);
        long t2 = new Date().getTime();
        Arrays.sort(result2);
        long t3 = new Date().getTime();
        System.out.println("After sorted: " + Arrays.toString(result) +
                "\nSelectionSort costs " + (t1 - t0) +
                "\nInsertionSort: " + (t2 - t1) +
                "\nArrays.sort: " + (t3 - t2));
    }
}
