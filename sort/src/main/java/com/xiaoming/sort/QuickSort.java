package com.xiaoming.sort;

/**
 * @author Xiaoming.
 * Created with IntelliJ IDEA on 2018/03/03 17:12.
 * Description :
 */
public class QuickSort {

    private static int partition0Origin(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (a[j] <= pivot) {    //use  "<" replace "<=" ??
                i++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[i + 1];
        a[i + 1] = a[r];
        a[r] = t;

        return i + 1;
    }

    static void quickSort0Origin(int[] a, int p, int r) {
        if (p < r) {
            int q = partition0Origin(a, p, r);
            quickSort0Origin(a, p, q - 1);
            quickSort0Origin(a, q + 1, r);
        }
    }

    private static int randomizedPartition(int[] a, int p, int r) {
        int i = (int) (Math.random() * (r - p) + p);
        int t = a[r];
        a[r] = a[i];
        a[i] = t;
        return partition0Origin(a, p, r);
    }

    static void quickSort0Randomized(int[] a, int p, int r) {
        if (p < r) {
            int q = randomizedPartition(a, p, r);
            quickSort0Randomized(a, p, q - 1);
            quickSort0Randomized(a, q + 1, r);
        }
    }

    private static int randomizedPartition1Optimization(int[] a, int p, int r) {
        int i = (int) (Math.random() * (r - p) + p);
        int t = a[r];
        a[r] = a[i];
        a[i] = t;

        int pivot = a[r];
        i = p - 1;
        for (int j = p; j < r; j++) {
            if (a[j] < pivot) {    //use  "<" replace "<=" ??
                i++;
                t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        t = a[i + 1];
        a[i + 1] = a[r];
        a[r] = t;

        return i + 1;
    }

    static void quickSort1Self(int[] a, int p, int r) {
        if (p < r) {
            int q = randomizedPartition1Optimization(a, p, r);
            quickSort1Self(a, p, q - 1);
            quickSort1Self(a, q + 1, r);
        }
    }

    static void quicksortVerBaidu(int arr[], int low, int high) {
        int l = low;
        int h = high;
        int povit = arr[low];

        while (l < h) {
            while (l < h && arr[h] >= povit) h--;
            if (l < h) {
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
                l++;
            }

            while (l < h && arr[l] <= povit) l++;

            if (l < h) {
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
                h--;
            }
        }
        if (l > low) quicksortVerBaidu(arr, low, l - 1);
        if (h < high) quicksortVerBaidu(arr, l + 1, high);
    }

    static void quicksortVerCsdn(int[] array, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }

        int standard = array[startIndex]; // 定义标准
        int leftIndex = startIndex; // 左指针
        int rightIndex = endIndex; // 右指针

        while (leftIndex < rightIndex) {
            while (leftIndex < rightIndex && array[rightIndex] >= standard) {
                rightIndex--;
            }
            array[leftIndex] = array[rightIndex];

            while (leftIndex < rightIndex && array[leftIndex] <= standard) {
                leftIndex++;
            }
            array[rightIndex] = array[leftIndex];
        }

        array[leftIndex] = standard;

        quicksortVerCsdn(array, startIndex, leftIndex - 1);
        quicksortVerCsdn(array, leftIndex + 1, endIndex);
    }

/*
    public static void main(String[] args) {
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.println("mode ? (1: Duplicate, 0: exit, else: NoDuplicate, 2: Reverse, 4: Sorted");
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
            if (mode == 4) {
                Arrays.sort(a);
            }
            //System.out.println("Before sorted: " + Arrays.toString(a));

            int[] result0 = a.clone();
            int[] result1 = a.clone();
            int[] result2 = a.clone();
            int[] result3 = a.clone();
            int[] result4 = a.clone();

            long t0 = System.nanoTime();
            Arrays.sort(result0, 0, result0.length - 1);
            long t1 = System.nanoTime();
            InsertionSort.insertionSort0(result1);
            long t2 = System.nanoTime();
            MergeSort.mergeSort0(result2);
            long t3 = System.nanoTime();
            MergeSort.mergeInsertionSort0(a, 0, a.length - 1);
            long t4 = System.nanoTime();
            quickSort0_Randomized(result3, 0, result3.length - 1);
            long t5 = System.nanoTime();
            quickSort1_Self(result4, 0, result4.length - 1);
            long t6 = System.nanoTime();
            long t7 = System.nanoTime();

//            System.out.println("is: " + Arrays.toString(result1));
//            System.out.println("mg: " + Arrays.toString(result2));
//            System.out.println("mgis: " + Arrays.toString(a));
//            System.out.println("rdm: " + Arrays.toString(result3));
//            System.out.println("self: " + Arrays.toString(result4));

            long i1 = (t1 - t0);
            long i2 = (t2 - t1);
            long i3 = (t3 - t2);
            long i4 = (t4 - t3);
            long i5 = (t5 - t4);
            long i6 = t6 - t5;

            System.out.println("after sort: " +*//* Arrays.toString(result1) +*//*
                    "\nArrays.sort:           " + nsToMcsMs(i1) +
                    "\ninsertionSort0:        " + nsToMcsMs(i2) +
                    "\nmergeSort0:            " + nsToMcsMs(i3) +
                    "\nmgis:                  " + nsToMcsMs(i4) +
                    "\nquickSort0_Randomized: " + nsToMcsMs(i5) +
                    "\nquickSort1_Self:       " + nsToMcsMs(i6) +
                    "\ncmp:" + (t7 - t6));
        }
    }*/
}
