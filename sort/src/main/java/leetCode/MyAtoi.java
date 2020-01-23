package leetCode;

/**
 * @author Xiaoming.
 * Created on 2019/07/26 19:29.
 */
public class MyAtoi {
    public static int atoi(String str) {
        if (str == null || str.length() == 0) {
            // TODO
            return 0;
        }

        char[] chars = str.toCharArray();

        // find out the beginning character of number
        int i = 0;
        while (i < chars.length && (chars[i] < '0' || chars[i] > '9')) {
            i++;
        }
        // find the end of number
        int j = i;
        while (j < chars.length && (chars[j] >= '0' && chars[j] <= '9')) {
            j++;
        }

        if (i > chars.length) {
            // TODO
            return 0;
        }

        boolean negative = false;
        if (i > 0 && chars[i - 1] == '-') {
            negative = true;
        }

        int result = 0;
        int limit = Integer.MAX_VALUE / 10;
        while (i < j) {
            if (result > limit) {
                if (negative) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
            result *= 10;
            int digit = chars[i++] - '0';
            if (result > Integer.MAX_VALUE - digit) {
                if (negative) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
            result += digit;
        }

        return negative ? -result : result;
    }

    public static void main(String[] args) {
        System.out.println(atoi(Integer.MIN_VALUE + ""));
        Integer.parseInt("123");
    }
}
