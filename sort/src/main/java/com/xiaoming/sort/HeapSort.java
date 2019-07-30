package com.xiaoming.sort;

import com.xiaoming.util.RandomArray;

import java.util.Arrays;
import java.util.Date;

/**
 * @author Xiaoming.
 * Created with IntelliJ IDEA on 2018/03/02 21:42.
 * Description :
 */
public class HeapSort {

    private static int heapSize;

    private static void maxHeapify(int[] a, int i) {
        int l = 2 * i + 1;  //l = left(i){  return 2i;}
        int r = 2 * i + 2;  //r = right(i){  return 2i + 1;}
        int largest;
        if (l < heapSize && a[l] > a[i]) {
            largest = l;
        } else {
            largest = i;
        }
        if (r < heapSize && a[r] > a[largest]) {
            largest = r;
        }
        if (largest != i) {
            int t = a[i];
            a[i] = a[largest];
            a[largest] = t;
            maxHeapify(a, largest);
        }
    }

    private static void buildMaxHeap(int[] a) {
        heapSize = a.length;
        for (int i = a.length / 2 - 1 ; i >= 0; i--) {
            maxHeapify(a, i);
        }
    }

    static void heapSort0(int[] a) {
        buildMaxHeap(a);
        for (int i = a.length - 1; i > 0; i--) {
            int t = a[i];
            a[i] = a[0];
            a[0] = t;
            heapSize--;
            maxHeapify(a, 0);
        }
    }

    public static void main(String[] args) {
        while (true) {
            int[] a =
                    //{7,4,10,5,2,1,6,3,8,9};
                    //RandomGenerator.randomWithInputNoDuplicate();
                    RandomArray.duplicateRandomArrayWithInput();

            System.out.println("Before sorted: " + Arrays.toString(a));

            int[] result0 = a.clone();
            int[] result1 = a.clone();
            int[] result2 = a.clone();
            long t0 = new Date().getTime();
            SelectionSort.selectionSort0(result0);
            long t1 = new Date().getTime();
            InsertionSort.insertionSort0(result1);
            long t2 = new Date().getTime();
            MergeSort.mergeSort0(result2);
            long t3 = new Date().getTime();
            heapSort0(a);
            long t4 = new Date().getTime();
            System.out.println("after sort: " + Arrays.toString(a) +
                    "\nselectionSort0: " + (t1 - t0) +
                    "\ninsertionSort0: " + (t2 - t1) +
                    "\nmergeSort0 : " + (t3 - t2) +
                    "\nheapSort0: " + (t4 - t3));
        }
    }

}
