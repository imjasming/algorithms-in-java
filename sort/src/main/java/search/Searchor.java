package search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Xiaoming.
 * Created with IntelliJ IDEA on 2018/02/28 17:18.
 * Description :
 */
public class Searchor {

    public static int sequenceSearch_Recursive(int[] a, int e, int lowIndex, int highIndex) {
        if (lowIndex <= highIndex) {
            if (a[lowIndex] == e) {
                return lowIndex;
            } else {
                return sequenceSearch_Recursive(a, e, lowIndex + 1, highIndex);
            }
        }
        return -1;
    }

    public static int sequenceSearch_Loop(int[] a, int e) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == e) {
                return i;
            }
        }
        return -1;
    }

    private static int binarySearch_Recursive_ForArrayIndex(int[] a, int e, int largeIndex, int smallIndex) {
        if (largeIndex > smallIndex) {
            int mid = (largeIndex + smallIndex) / 2;
            if (a[mid] < e) {
                return binarySearch_Recursive_ForArrayIndex(a, e, largeIndex, mid + 1);
            } else {
                return binarySearch_Recursive_ForArrayIndex(a, e, mid, smallIndex);
            }
        } else {
            if (e < a[smallIndex]) {
                return smallIndex;
            } else {
                return smallIndex + 1;
            }
        }
    }

    public static int binarySearch_Recursive(int[] a, int e, int lowIndex, int highIndex) {
        if (highIndex > lowIndex) {
            int mid = (highIndex + lowIndex) / 2;
            if (e > a[mid]) {
                return binarySearch_Recursive(a, e, mid + 1, highIndex);
            } else {
                return binarySearch_Recursive(a, e, lowIndex, mid);
            }
        } else {
            if (e == a[lowIndex]) {
                return lowIndex;
            } else {
                return -1;
            }
        }
    }

    public static int binarySearch_Loop_Baidu(int[] srcArray, int des) {
        //定义初始最小、最大索引
        int low = 0;
        int high = srcArray.length - 1;
        //确保不会出现重复查找，越界
        while (low <= high) {
            //计算出中间索引值
            int middle = (high + low) >>> 1;//防止溢出
            if (des == srcArray[middle]) {
                return middle;
                //判断下限
            } else if (des < srcArray[middle]) {
                high = middle - 1;
                //判断上限
            } else {
                low = middle + 1;
            }
        }
        //若没有，则返回-1
        return -1;
    }

    public static int binarySearch_Recursive(int[] a, int des) {
        if (a == null) {
            throw new NullPointerException();
        }
        return binarySearch_Recursive(a, des, 0, a.length - 1);
    }


    public static void main(String[] args) throws InterruptedException {
        try (Scanner in = new Scanner(System.in)) {
            while (true) {
                System.out.println("What is the highest number of array? ");
                int n = in.nextInt();
                int[] a = new int[n];
                for (int i = 0; i < n; i++) {
                    a[i] = i + 1;
                }
                System.out.println(Arrays.toString(a));
                System.out.println("what is the number you want to search out");
                int e = in.nextInt();

                int result0;
                int result1;
                int result2;
                int result3;
                Thread.sleep(1000);
                long t0 = System.nanoTime();
                result0 = binarySearch_Recursive(a, e, 0, a.length - 1);
                long t1 = System.nanoTime();
                result1 = binarySearch_Loop_Baidu(a, e);
                long t2 = System.nanoTime();
                result2 = sequenceSearch_Loop(a, e);
                long t3 = System.nanoTime();
                //result3 = sequenceSearch_Recursive(a,e,0,a.length - 1);
                long t4 = System.nanoTime();
                System.out.println("binarySearch_Recursive: time " + (t1 - t0) + " , result " + result0 +
                                "\nbinarySearch_Loop_Baidu: time " + (t2 - t1) + " , result " + result1 +
                                "\nsequenceSearch_Loop : time " + (t3 - t2) + " , result " + result2 //+
                        /*"\nsequenceSearch_Recursive: time " + (t4 -t3) + " , result " + result3*/);
            }
        }
    }
}
