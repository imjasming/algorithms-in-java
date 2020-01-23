package leetCode;

/**
 * @author Xiaoming.
 * Created on 2019/07/24 21:59.
 */
public class ReverseInteger {
    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static int reverse2(int x) {
        boolean isNegative = x < 0;
        String s = Integer.toString(x);
        char[] nums;
        if (isNegative) {
            nums = s.substring(1).toCharArray();
        } else {
            nums = s.toCharArray();
        }
        int i = 0, j = nums.length - 1;
        char temp;
        while (i < j) {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            i++;
            j--;
        }

        s = new String(nums);
        try {
            return isNegative ? -Integer.parseInt(s) : Integer.parseInt(s);

        } catch (Exception e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        int[][] t = new int[2][];
        t[1] = new int[3];
        System.out.println(reverse(1534236469));
    }
}
