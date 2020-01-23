package leetCode;

/**
 * @author Xiaoming.
 * Created on 2019/07/20 14:57.
 */
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        final char[] str = s.toCharArray();
        final int len = str.length;
        if (len == 0) {
            return len;
        }

        int start = 0, end = 0;
        int newstart = start;

        int i = 1;
        for (; i < len; i++) {
            char c = str[i];
            for (int j = newstart; j < i; j++) {
                if (str[j] == c) {
                    int l = i - j;
                    int l2 = end - start + 1;
                    if (l > l2) {
                        start = j + 1;
                        end = i;
                    }

                    newstart = j + 1;
                    break;
                }
            }
            if (newstart == start) {
                end = i;
            } else if (i - newstart > end - start) {
                start = newstart;
                end = i;
            }
        }

        return Math.max(end - start + 1, i - newstart);
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("ohomm"));
    }
}
