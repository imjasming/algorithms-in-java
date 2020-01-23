package interview.byteD;

/**
 * @author Xiaoming.
 * Created on 2019/08/11 19:06.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int num = in.nextInt();
        if (num <= 0) {
            return;
        }

        int[][] matrix = new int[num][];
        for (int i = 0; i < num; i++) {
            matrix[i] = new int[num];
            Arrays.fill(matrix[i], 0);
        }

        for (int i = 0; i < num - 1; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            if (u > num || u < 1 || v > num || v < 1) {
                return;
            }
            matrix[u - 1][v - 1] = matrix[v - 1][u - 1] = 1;
        }


    }


}