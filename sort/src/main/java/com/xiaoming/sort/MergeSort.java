package com.xiaoming.sort;


import com.xiaoming.util.RandomArray;

/**
 * @author Xiaoming.
 * Created with IntelliJ IDEA on 2018/02/21 12:15.
 * Description :
 */
public class MergeSort {

    /**
     * 归并排序的关键操作为对两个已排序序列的合并。lowIndex，midIndex，highIndex 为数组下标，满足 lowIndex <= midIndex < highIndex，该过程假设子数组
     * a[lowIndex...midIndex]和a[lowIndex+1...highIndex]都已排好序。该方法合并两个子数组形成单一的已排好序的子数组并代替当前的子数组a[lowIndex...highIndex]。
     * 输入堆数组 L[(midIndex-lowIndex+1) + 1] 和 R[highIndex-midIndex + 1] 分别copy已排好序的 a[] 的两个子序列（lowIndex to midIndex，midIndex+1 to highIndex)。
     * 基本步骤为将两个数组中顶上的（未放回a[]的最大下标的元素）两元素进行比较，选取较小的元素移出（比较的下标++)
     * 并放回输出堆原数组 a[], 重复此步骤直到输入堆为空（这里为简化代码，以避免每次检查数组是否为空，将输入堆数组
     * 最大下标元素赋最大整数值）。因只比较顶上两元素，所以计算上每个基本步骤需常量时间，最多执行 n = highIndex - lowIndex + 1个
     * 基本步骤，所以合并需 Θ(n) 的时间
     *
     * @param a         the array need to merge
     * @param lowIndex  the starting index
     * @param midIndex  the mid index
     * @param highIndex the end index
     * @see MergeSort#mergeSort(int[], int, int)
     */
    private static void merge(int[] a, int lowIndex, int midIndex, int highIndex) {
        int n1 = midIndex - lowIndex + 1;
        int n2 = highIndex - midIndex;

        int[] L = new int[n1 + 1];
        int[] R = new int[n2 + 1];

        System.arraycopy(a, lowIndex, L, 0, L.length - 1);
        System.arraycopy(a, midIndex + 1, R, 0, R.length - 1);

        /*for(int i = 0;i < L.length - 1;i++){
            L[i] = a[lowIndex + i];
        }
        for(int i = 0;i < R.length - 1;i++){
            R[i] = a[midIndex + i + 1];
        }*/
        //R = Arrays.copyOfRange(a,midIndex + 1,highIndex);

        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;

        //<循环不变式>
        int i = 0;
        int j = 0;
        for (int k = lowIndex; k <= highIndex; k++) {
            if (L[i] <= R[j]) {
                a[k] = L[i];
                i++;
            } else {
                a[k] = R[j];
                j++;
            }
        }
        //</循环不变式>
    }

    /**
     * 递归地将数组 a[] 分解成两个子数组：若 p>=r,则该子数组最多有一个元素，所以已经排好序。否则，
     * 分解步骤简单地计算一个下标q，将a[] 分解成 a[p...q] 和a[q+1...r] 。
     * 为排好整个序列 a[] = {a[1],a[2]...a[n]},初始调用 mergeSort(a, 0, a.length).
     * 算法由一下操作组成：合并只含 1 项的序列对形成长度为 2 的排好序的序列，合并长度为 2 的序列对形
     * 成长度为 4 的已排好序的序列，重复下去直到长度为 n/2 的两序列合并成 长度为 n 的排好序的序列
     *
     * @param a the array need to merge
     * @param p the starting index
     * @param r the end index
     * @see MergeSort#merge(int[], int, int, int)
     */
    static void mergeSort(int[] a, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(a, p, q);
            mergeSort(a, q + 1, r);
            merge(a, p, q, r);

            //System.out.println(Arrays.toString(a));
//            for (int e: a){
//                for (int i = 0;i < e;i++){
//                    System.out.print("-");
//                }
//                System.out.println();
//            }
//            System.out.println("**************************************");
        }
    }

    static void mergeSort0(int[] a) {
        mergeSort(a, 0, a.length - 1);
    }

    public static void mergeSort(int[] a) {
        if (a == null) {
            throw new NullPointerException();
        }
        mergeSort(a, 0, a.length - 1);
    }

    private static int INSERTION_SORT_THRESHOLD = 128;

    public static void setInsertionSortThreshold(int insertionSortThreshold) {
        INSERTION_SORT_THRESHOLD = insertionSortThreshold;
    }

    static void mergeInsertionSort0(int[] a, int p, int r) {
        if (p < r) {
            if (r - p < INSERTION_SORT_THRESHOLD) {
                InsertionSort.insertionSort0(a, p, r);
            } else {
                int q = (p + r) / 2;
                mergeInsertionSort0(a, p, q);
                mergeInsertionSort0(a, q + 1, r);
                merge(a, p, q, r);
            }
        }
    }

    public void mergeInsertionSort(int[] a) {
        if (a == null) {
            throw new NullPointerException();
        }
        mergeInsertionSort0(a, 0, a.length - 1);
    }

    public static void main(String[] args){
        for (int i = 2; i < 10000; i++) {
            int[] a = RandomArray.noDuplicateRandomArray(10000, 10000);
            int[] a1 = a.clone();
            MergeSort.setInsertionSortThreshold(i);

            long t0 = System.nanoTime();
            mergeSort(a);
            long t1 = System.nanoTime();
            mergeSort0(a1);
            long t2 = System.nanoTime();
            System.out.println(i + " : " + ((t1 - t0) - (t2 - t1)));

            a = null;
            a1 = null;
            System.gc();
        }
    }
}
