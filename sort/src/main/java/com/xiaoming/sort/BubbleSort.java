package com.xiaoming.sort;

import com.xiaoming.util.RandomArray;

import java.util.Arrays;
import java.util.Date;

/**
 * @author Xiaoming.
 * Created on 2019/07/16 16:04.
 */
public class BubbleSort {

    public static void BubbleSort0(int[] array) {
        for (int i = 0; i < array.length - 1; i++) { // 若最小元素在序列末尾，需要 n-1 次交换，才能交换到序列开头
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {  // 若这里的条件是 >=，则变成不稳定排序
                    int t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;
                }
            }
        }
    }

    public static void BubbleSort1(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            boolean changed = false;
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;
                    changed = true;
                }
            }
            if (!changed) {
                break;
            }
        }
    }

    public static void BubbleSort2(int[] array) {
        int n = array.length;
        for (int i = 0; i < array.length - 1; i++) {
            int newn = 0;
            for (int j = 0; j < n - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;
                    newn = j + 1;   // newn 以及之后的元素，都是排好序的
                }
            }

            n = newn;

            if (n == 0) {
                break;
            }
        }
    }

    public static void CocktailSort(int[] array) {
        int begin = 0;
        int end = array.length - 1;
        while (begin <= end) {
            int newBegin = end;
            int newEnd = begin;

            for (int j = begin; j < end; j++) {
                if (array[j] > array[j + 1]) {
                    int t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;
                    newEnd = j + 1;
                }
            }

            end = newEnd - 1;

            for (int j = end; j > begin; j--) {
                if (array[j] < array[j - 1]) {
                    int t = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = t;
                    newBegin = j;
                }
            }

            begin = newBegin;
        }
    }

    public static void main(String[] args) {
        int[] result = RandomArray.randomWithInputNoDuplicate();
        int[] result1 = result.clone();
        int[] result2 = result.clone();
        int[] result3 = result.clone();

        System.out.println("Before sorted: " + Arrays.toString(result));
        long t0 = new Date().getTime();
        BubbleSort0(result);
        long t1 = new Date().getTime();
        BubbleSort1(result1);
        long t2 = new Date().getTime();
        BubbleSort2(result2);
        long t3 = new Date().getTime();
        CocktailSort(result3);
        long t4 = new Date().getTime();
        /*System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));*/
        System.out.println(Arrays.toString(result3));
        System.out.println("---------------------" +
                "\n0: " + (t1 - t0) +
                "\n1: " + (t2 - t1) +
                "\n2: " + (t3 - t2) +
                "\n3: " + (t4 - t3)
        );
    }
}
