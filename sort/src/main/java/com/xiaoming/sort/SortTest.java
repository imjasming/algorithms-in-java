package com.xiaoming.sort;


import java.text.NumberFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Xiaoming.
 * Created on 2019/01/12 22:18.
 * Description :
 */
public class SortTest {
    static void printArray(String[] idn, int[]... as) {
        for (int i = 0; i < as.length; i++) {
            System.out.println(idn[i] + ": " + Arrays.toString(as[i]));
        }
    }

    static void getAvgCostTime(long f, int[] a) throws ClassNotFoundException, InterruptedException {
        long s0, s1, s2, s3, s4, s5, s6;
        s0 = s1 = s2 = s3 = s4 = s5 = s6 = 0;

        for (int i = 0; i < f; i++) {
            //int[] a = RandomGenerator.generateNoDuplicateRandomArray(n, max);
            int[] a0 = a.clone();
            int[] a1 = a.clone();
            int[] a2 = a.clone();
            int[] a3 = a.clone();
            int[] a4 = a.clone();
            int[] a5 = a.clone();

            //Thread.sleep(1);
            String first = "first";
            String t = "third";


            long t0 = System.nanoTime();
            Map<String, String> map = new HashMap<>();
            map.put("id", "1");
            map.put("name", "name");
            map.put("info", "info");

            System.out.println();

            // QuickSort.quickSort1_Self(a1, 0, a1.length - 1);
            long t1 = System.nanoTime();
            //MergeSort.mergeInsertionSort0(a0, 0, a.length - 1);
            long t2 = System.nanoTime();
            //MergeSort.mergeSort(a3, 0, a.length - 1);
            long t3 = System.nanoTime();
            //Arrays.sort(a2);
            long t4 = System.nanoTime();
            //HeapSort.heapSort0(a4);
            long t5 = System.nanoTime();
            //CountingSort.countingSort(a5);
            long t6 = System.nanoTime();

            s1 += (t1 - t0);
            s2 += (t2 - t1);
            s3 += (t3 - t2);
            s4 += (t4 - t3);
            s5 += (t5 - t4);
            s6 += t6 - t5;
        }

        System.out.println(
                "\nqSort:                 " + nsToMcsMs(s1 / f) +
                        "\nmgis:                  " + nsToMcsMs(s2 / f) +
                        "\nmergeSort0:            " + nsToMcsMs(s3 / f) +
                        "\ninsertionSort0:        " + nsToMcsMs(s4 / f) +
                        "\nheapSort0:             " + nsToMcsMs(s5 / f) +
                        "\ncounting:              " + nsToMcsMs(s6 / f)/* +
                "\n**************************************************"*/);
    }

    static String nsToMcsMs(long t) {
        return NumberFormat.getInstance().format(t);
    }

    public static void main(String[] args) throws InterruptedException, ClassNotFoundException {
        Class.forName("com.xiaoming.sort.HeapSort");
        Class.forName("com.xiaoming.sort.InsertionSort");
        Class.forName("com.xiaoming.sort.MergeSort");
        Class.forName("java.util.Arrays");
        Class.forName("com.xiaoming.sort.QuickSort");
        Class.forName("com.xiaoming.sort.CountingSort");
        args = new String[] {""};

        //while (true){
            /*Scanner in = new Scanner(System.in);
            System.out.println("mode ? (1: Duplicate, 2: Reverse, 3: Sorted, 0: exit, else: NoDuplicate");
            int mode = in.nextInt();*/

        int[] a = new int[1];
        HashMap<Integer, Integer> map = new HashMap<>();
        map.containsKey(0);
        int[] aa = new int[]{1,2};


            /*if (mode == 0) {
                break;
            } else if (mode == 1) {
                a = RandomGenerator.randomWithInput();
            } else {
                a = RandomGenerator.randomWithInputNoDuplicate();
            }
            if (mode == 2) {
                a = ArrayReversor.sortAndReverse(a);
            }
            if (mode == 3) {
                Arrays.sort(a);
            }*/

        getAvgCostTime(100, a);
        //}

        /*Thread.sleep(1000);
        for (int i = 8; i < 2048; i++) {
            getAvgCostTime(1000, i, i);
            Thread.sleep(1);
        }*/

        /*while (true) {
            Scanner in = new Scanner(System.in);
            System.out.println("mode ? (1: Duplicate, 2: Reverse, 3: Sorted, 0: exit, else: NoDuplicate");
            int mode = in.nextInt();

            int[] a;

            if (mode == 0) {
                break;
            } else if (mode == 1) {
                a = RandomGenerator.randomWithInput();
            } else {
                a = RandomGenerator.randomWithInputNoDuplicate();
            }
            if (mode == 2) {
                a = ArrayReversor.sortAndReverse(a);
            }
            if (mode == 3) {
                Arrays.sort(a);
            }

            int[] a1 = a.clone();
            int[] a2 = a.clone();
            int[] a3 = a.clone();
            int[] a4 = a.clone();

//            System.out.println("Before sorted: " + Arrays.toString(a));

            long t0 = System.nanoTime();
            Arrays.sort(a1);
            long t1 = System.nanoTime();
            MergeSort.mergeInsertionSort0(a, 0, a.length - 1);
            long t2 = System.nanoTime();
            MergeSort.mergeSort(a3, 0, a.length - 1);
            long t3 = System.nanoTime();
            InsertionSort.insertionSort0(a2);
            long t4 = System.nanoTime();
            HeapSort.heapSort0(a4);
            long t5 = System.nanoTime();
            long t6 = System.nanoTime();

            long i1 = (t1 - t0);
            long i2 = (t2 - t1);
            long i3 = (t3 - t2);
            long i4 = (t4 - t3);
            long i5 = (t5 - t4);
            long i6 = t6 - t5;

            *//*String[] sa = {"Arrays.sort", "insertionSort0", "merge", "mgis", "heap"};
            printArray(sa, a1, a2, a3, a, a4);*//*

            System.out.println("after sort: " +*//* Arrays.toString(result1) +*//*
                    "\nArrays.sort:           " + nsToMcsMs(i1) +
                    "\nmgis:                  " + nsToMcsMs(i2) +
                    "\nmergeSort0:            " + nsToMcsMs(i3) +
                    "\ninsertionSort0:        " + nsToMcsMs(i4) +
                    "\nheapSort0:             " + nsToMcsMs(i5) +
                    "\ncmp:" + i6);
        }*/
    }
}
