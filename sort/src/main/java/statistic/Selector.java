package statistic;

/**
 * @author Xiaoming.
 * Created with IntelliJ IDEA on 2018/03/10 17:06.
 * Description :
 */
public class Selector {

    static MaxMin findMaxAndMin0_LOOP(int[] a) {
        if (a.length == 1) {
            return new MaxMin(a[0], a[0]);
        }
        int max;
        int min;
        int i;
        if (a.length % 2 == 0) {
            if (a[0] >= a[1]) {
                max = a[0];
                min = a[1];
            } else {
                max = a[1];
                min = a[0];
            }

            if (a.length == 2) {
                return new MaxMin(max, min);
            }

            i = 2;
        } else {
            max = min = a[0];
            i = 1;
        }

        for (; i < a.length; i += 2) {
            if (a[i] >= a[i + 1]) {
                if (a[i] > max) {
                    max = a[i];
                }
                if (a[i + 1] < min) {
                    min = a[i + 1];
                }
            } else {
                if (a[i + 1] > max) {
                    max = a[i + 1];
                }
                if (a[i] < min) {
                    min = a[i];
                }
            }
        }

        return new MaxMin(max, min);
    }

    static MaxMin findMaxAndMin1_LOOP(int[] a) {
        if (a.length == 1) {
            return new MaxMin(a[0], a[0]);
        }

        int max = a[0];
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
            if (a[i] < min) {
                min = a[i];
            }
        }

        return new MaxMin(max, min);
    }

    private static int randomizedPartition(int[] a, int p, int r) {
        int i = (int) (Math.random() * (r - p) + p);
        int t = a[r];
        a[r] = a[i];
        a[i] = t;

        int pivot = a[r];
        i = p - 1;
        for (int j = p; j < r; j++) {
            if (a[j] <= pivot) {
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

    static int randomizedSelect(int[] a, int p, int r, int i) {
        if (p == r) {
            return a[p];
        }
        int q = randomizedPartition(a, p, r);
        int k = q - p + 1;
        if (i == k) {
            return a[q];
        } else if (i < k) {
            return randomizedSelect(a, p, q - 1, i);
        } else {
            return randomizedSelect(a, q + 1, r, i - k);
        }
    }
}

class MaxMin {
    private int max;
    private int min;

    public MaxMin() {
    }

    MaxMin(int max, int min) {
        this.max = max;
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }
}
