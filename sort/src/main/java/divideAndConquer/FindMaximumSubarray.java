package divideAndConquer;

import java.util.Arrays;

/**
 * @author Xiaoming.
 * Created with IntelliJ IDEA on 2018/02/25 23:14.
 * Description :
 */
public class FindMaximumSubarray {

    private static MaximumSubarray findMaxCrossingSubarray(int[] a, int low, int mid, int high) {
        int sum = 0;
        int maxLeftIndex = mid;
        int leftSum = Integer.MIN_VALUE;
        for (int i = mid; i >= low; i--) {
            sum += a[i];
            if (sum > leftSum) {
                leftSum = sum;
                maxLeftIndex = i;
            }
        }

        sum = 0;
        int maxRightIndex = mid + 1;
        int rightSum = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= high; i++) {
            sum += a[i];
            if (sum > rightSum) {
                rightSum = sum;
                maxRightIndex = i;
            }
        }

        return new MaximumSubarray(maxLeftIndex, maxRightIndex, leftSum + rightSum);
    }

    public static MaximumSubarray findMaximumSubarray(int[] a, int low, int high) {
        if (low == high) {
            return new MaximumSubarray(low, high, a[low]);
        } else {
            int mid = (low + high) / 2;
            MaximumSubarray left = findMaximumSubarray(a, low, mid);
            MaximumSubarray right = findMaximumSubarray(a, mid + 1, high);
            MaximumSubarray cross = findMaxCrossingSubarray(a, low, mid, high);  //#6
            if (left.sum >= right.sum && left.sum >= cross.sum) {
                return left;
            } else if (right.sum >= left.sum && right.sum >= cross.sum) {
                return right;
            } else {
                return cross;
            }
        }
    }

    public static MaximumSubarray findMaximumSubarray(int[] a) {
        if (a == null) {
            throw new NullPointerException();
        }
        return findMaximumSubarray(a, 0, a.length - 1);
    }

    public static void main(String[] args) {
        int[] a = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        MaximumSubarray maximumSubarray = findMaximumSubarray(a);
        int[] sub = new int[maximumSubarray.getHighIndex() - maximumSubarray.getLowIndex() + 1];
        System.arraycopy(a, maximumSubarray.getLowIndex(), sub, 0, sub.length);
        System.out.println(Arrays.toString(a) + "\n" + Arrays.toString(sub));
    }
}

class MaximumSubarray {
    private int lowIndex = Integer.MIN_VALUE;
    private int highIndex = Integer.MIN_VALUE;
    int sum = 0;
    //private int[] superArray;

    MaximumSubarray(int l, int h, int s/*, int[] a*/) {
        lowIndex = l;
        highIndex = h;
        sum = s;
        //superArray = a;
    }

    public MaximumSubarray() {
    }

    //public int[] getMaxSubarray(){}

    public int getHighIndex() {
        return highIndex;
    }

    public int getLowIndex() {
        return lowIndex;
    }

    public int getSum() {
        return sum;
    }
}