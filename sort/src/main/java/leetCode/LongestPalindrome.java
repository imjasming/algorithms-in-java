package leetCode;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] str = s.toCharArray();
        int longest = 0;
        int index = 0;
        for (int i = 0; i < str.length; i++) {
            int len1 = expand(str, i, i);
            int len2 = expand(str, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > longest) {
                longest = len;
                index = i;
            }
        }
        if (longest % 2 == 1) {
            return s.substring(index - longest / 2, index + longest / 2 + 1);
        } else {
            return s.substring(index - longest / 2 + 1, index + longest / 2 + 1);
        }
    }

    private static int expand(char[] str, int start, int end) {

        while (start > -1 && end < str.length && str[start] == str[end]) {
            start--;
            end++;
        }
        return end - start - 1; // end - 1 - (start + 1) + 1
    }

    public static void main(String[] args) {
        String s = "ababd";
        System.out.println(longestPalindrome2(s));
    }
}
