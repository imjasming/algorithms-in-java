package com.xiaoming.sort;

import com.xiaoming.util.ArrayReversor;
import com.xiaoming.util.RandomArray;

import java.util.Arrays;
import java.util.Scanner;

import static com.xiaoming.sort.QuickSort.quickSort1Self;

/**
 * @author Xiaoming.
 * Created with IntelliJ IDEA on 2018/03/10 01:08.
 * Description :
 */
public class CountingSort {

    static void countingSort(int[] a, int[] b, int k) {
        int[] c = new int[k];
        Arrays.fill(c, 0);

        for (int i = 0; i < a.length; i++) {
            c[a[i] - 1]++;
        }

        for (int i = 1; i < c.length; i++) {
            c[i] += c[i - 1];
        }

        for (int i = a.length - 1; i > -1; i--) {
            b[c[a[i] - 1] - 1] = a[i];
            c[a[i] - 1]--;
        }
    }

    public static void countingSort(int[] a) {
        int k = Integer.MIN_VALUE;
        for (int i : a) {
            if (i > k) {
                k = i;
            }
        }

        int[] b = a.clone();
        countingSort(b, a, k);
    }

    public static void main(String[] args) {
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.println("mode ? (1: Duplicate, 0: exit, else: NoDuplicate, 2: Reverse, 4: Sorted");
            int mode = in.nextInt();

            int[] a;


            if (mode == 0) {
                break;
            } else if (mode == 1) {
                a = RandomArray.duplicateRandomArrayWithInput();
            } else {
                a = RandomArray.randomWithInputNoDuplicate();
            }
            if (mode == 2) {
                a = ArrayReversor.sortAndReverse(a);
            } else if (mode == 4) {
                Arrays.sort(a);
            }
            //System.out.println("Before sorted: " + Arrays.toString(a));

            int[] result0 = a.clone();
            int[] result1 = a.clone();
            int[] result2 = a.clone();
            int[] result3 = a.clone();

            System.out.println(Arrays.toString(result0));

            long t0 = System.nanoTime();
            quickSort1Self(result0, 0, result0.length - 1);
            long t1 = System.nanoTime();
            HeapSort.heapSort0(result1);
            long t2 = System.nanoTime();
            MergeSort.mergeSort0(result2);
            long t3 = System.nanoTime();
            Arrays.sort(a, 0, a.length - 1);
            long t4 = System.nanoTime();
            countingSort(result3);
            long t5 = System.nanoTime();

            System.out.println(Arrays.toString(result0));

            System.out.println("after sort: " +/* Arrays.toString(result3) +*/
                    "\nquickSort1_Self: " + (t1 - t0) +
                    "\nheapSort0:       " + (t2 - t1) +
                    "\nmergeSort0:      " + (t3 - t2) +
                    "\nArrays.sort:     " + (t4 - t3) +
                    "\ncountingSort:    " + (t5 - t4));
        }
    }
}
