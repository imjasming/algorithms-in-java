package com.xiaoming.sort;

import com.xiaoming.util.RandomArray;

import java.util.Arrays;

/**
 * @author Xiaoming.
 * Created with IntelliJ IDEA on 2018/02/20 20:22.
 * Description :
 */
public class InsertionSort {
    private static int[] insertsortVerBaidu(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    //接下来是无用功
                    break;
                }
            }
        }
        return arr;
    }

    private static void insertionSortSwap(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && array[j - 1] > array[j]; j--) {
                int temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
            }
        }
    }

    @SuppressWarnings("unchecked")
    private static <T extends Comparable> void insertionSort0(T[] a) {
        for (int j = 1; j < a.length; j++) {
            T key = a[j];

            //insert a[j] into the sorted sequence a[0...j-1]
            int i = j - 1;
            while (i >= 0 && a[i].compareTo(key) > 0) {
                a[i + 1] = a[i];
                i--;
            }

            a[i + 1] = key;
        }
    }


    static void insertionsort0VerForloop(int[] a) {
        for (int j = 1; j < a.length; j++) {
            int key = a[j];

            //insert a[j] into the sorted sequence a[0...j-1]
            int i;
            for (i = j - 1; i >= 0 && a[i] > key; i--) {
                a[i + 1] = a[i];
            }

            a[i + 1] = key;
        }
    }

    static void insertionSort0(int[] a, int l, int r) {
        int to = r + 1;
        for (int j = l + 1; j < to; j++) {
            int key = a[j];

            int i = j - 1;
            while (i >= l && a[i] > key) {
                a[i + 1] = a[i];
                i--;
            }

            a[i + 1] = key;
        }
    }

    static void insertionSort0(int[] a) {
        int l = a.length;
        for (int j = 1; j < l; j++) {
            int key = a[j];

            //insert a[j] into the sorted sequence a[0...j-1]
            int i = j - 1;
            while (i >= 0 && a[i] > key) {
                a[i + 1] = a[i];
                i--;
            }

            a[i + 1] = key;
        }
    }

    public static void insertionSort(int[] a) {
        if (a == null) {
            throw new NullPointerException();
        }
        insertionSort0(a);
    }

    public static void main(String[] args) {
        int[] result = RandomArray.randomWithInputNoDuplicate();
        //int[] result = RandomGenerator.randomWithInput();

        /*Arrays.sort(result);
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(result));
        Collections.reverse(list);
        list.toArray(result);*/


        int[] result1 = result.clone();
        int[] result2 = result.clone();
        int[] result3 = result.clone();

        System.out.println("Before sorted: " + Arrays.toString(result1));
        long t0 = System.nanoTime();
        insertionSort0(result);
        long t1 = System.nanoTime();
        insertionSortSwap(result1);
        long t2 = System.nanoTime();
        insertsortVerBaidu(result2);
        long t3 = System.nanoTime();
        insertionsort0VerForloop(result3);
        long t4 = System.nanoTime();
        System.out.println("After sorted: " + Arrays.toString(result1) +
                "\ninsertionSort0:             " + (t1 - t0) +
                "\ninsertionSortSwap:          " + (t2 - t1) +
                "\ninsertSort_VER_Baidu:       " + (t3 - t2) +
                "\ninsertionSort0_VER_ForLoop: " + (t4 - t3));
    }
}
