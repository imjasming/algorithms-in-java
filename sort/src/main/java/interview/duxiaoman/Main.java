package interview.duxiaoman;

import java.util.Scanner;

/**
 * @author Xiaoming.
 * Created on 2019/09/29 18:36.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = in.nextInt();
        }

        System.out.println(f(n, data));
    }

    private static int f(int n, int[] data) {
        int count = 0;
        int max = Integer.MIN_VALUE, index = 0, sum = 0;
        int t;

        final int limit = (n - 1) / 2;
        while (sum(data) != 0) {
            sum = 0;
            index = 0;
            for (int i = 0; i < limit; i++) {
                sum += data[i];
                if (i != 2 * i) {
                    sum += data[2 * i];
                }
                sum += data[2 * i + 1];

                if (sum > max) {
                    max = sum;
                    index = i;
                }
            }

            t = data[index] > 0 ? --data[index] : data[index];
            if (index != 2 * index) {
                t = data[2 * index] > 0 ? --data[2 * index] : data[2 * index];
            }
            t = data[2 * index + 1] > 0 ? --data[2 * index + 1] : data[2 * index + 1];

            count++;
        }

        return count;
    }

    private static int sum(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }

        return sum;
    }
}
