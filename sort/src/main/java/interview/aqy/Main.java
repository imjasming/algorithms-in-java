package interview.aqy;


import java.util.Scanner;

/**
 * @author Xiaoming.
 * Created on 2019/09/08 14:52.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int red, blue;
        red = in.nextInt();
        blue = in.nextInt();

        double p = 0;

        int total = red + blue;
        p += (double) red / total;
        for (int i = 1; i < red; i++) {
            int restBlue = i * 3;
            if (restBlue > blue) {
                break;
            }
            p += (double) red / (double) (total - restBlue);
        }

        System.out.printf("%.5f", p);
    }
}
