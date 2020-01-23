package interview.byteD;

import java.util.Scanner;

/**
 * @author Xiaoming.
 * Created on 2019/08/11 21:11.
 */
public class Salary {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] level = new int[num];
        for (int i = 0; i < num; i++) {
            level[i] = in.nextInt();
            if (level[i] < 0) {
                return;
            }
        }

        int[] sa = new int[num];
        for (int i = 0; i < num; i++) {
            sa[i] = 100;
        }

        for (int i = 0; i < num - 1; i++) {
            if (level[i] > level[i + 1] && sa[i] <= sa[i + 1]) {
                sa[i] = sa[i + 1] + 100;
            } else if (level[i] < level[i + 1] && sa[i] >= sa[i + 1]) {
                sa[i + 1] = sa[i] + 100;
            }
        }
        for (int i = num - 1; i > 0; i--) {
            if (level[i] > level[i - 1] && sa[i] <= sa[i - 1]) {
                sa[i] = sa[i - 1] + 100;
            } else if (level[i] < level[i - 1] && sa[i] >= sa[i - 1]) {
                sa[i - 1] = sa[i] + 100;
            }
        }

        int sum = 0;
        for (int i : sa) {
            sum += i;
        }
        System.out.println(sum);
    }
}
