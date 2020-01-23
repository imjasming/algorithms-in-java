package interview.netEase;


/**
 * @author Xiaoming.
 * Created on 2019/09/21 14:58.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        int bag, n;
        int[] data;

        DataGroup[] dataGroups = new DataGroup[count];
        boolean flag = true;
        for (int j = 0; j < count; j++) {
            n = in.nextInt();
            bag = in.nextInt();
            data = new int[n];
            String t;
            for (int i = 0; in.hasNextInt(); i++) {
                //in.hasNextInt();
                data[i] = in.nextInt();
                //in.next().equals("");
            }

            dataGroups[j] = new DataGroup(n, bag, data);
        }
        for (int i = 0; i < dataGroups.length; i++) {
            if (!canComplete(dataGroups[i])) {
                flag = false;
                break;
            }
        }

        System.out.println(flag ? "YES" : "NO");
    }

    private static boolean canComplete(DataGroup d) {
        final int n = d.n;
        final int[] data = d.data;
        if (sumFormRange(n) > arrSum(d.data)) {
            return false;
        }
        int i = 0;
        int di, bag = d.bag;
        while (i < d.n) {
            di = data[i];
            if (di > i) {
                bag++;
                data[i]--;
            } else if (di < i) {
                if (di + bag < i) {
                    return false;
                } else {
                    bag -= i - di;
                    data[i] = i;
                    i++;
                }
            } else {
                i++;
            }
        }

        return true;
    }

    private static int arrSum(int[] a) {
        int sum = 0;
        for (int i : a) {
            sum += i;
        }

        return sum;
    }

    private static int sumFormRange(int up) {
        return --up * (up + 1) / 2;
    }

    private static class DataGroup {
        int n;
        int bag;
        int[] data;

        public DataGroup(int n, int bag, int[] data) {
            this.n = n;
            this.bag = bag;
            this.data = data;
        }
    }
}
