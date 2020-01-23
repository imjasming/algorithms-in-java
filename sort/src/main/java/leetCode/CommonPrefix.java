package leetCode;

/**
 * @author Xiaoming.
 * Created on 2019/07/29 15:14.
 */
public class CommonPrefix {
    public static String longestCommonPrefix_2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        int minLength = Integer.MAX_VALUE;
        for (String s : strs) {
            if (s == null) {
                return "";
            }
            minLength = s.length() < minLength ? s.length() : minLength;
        }
        StringBuilder sb = new StringBuilder();
        char key;
        for (int i = 0; i < minLength; i++) {
            key = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (key != strs[j].charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(key);
        }
        return sb.toString();
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    private static String longestCommonPrefix(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        } else {
            int mid = (l + r) / 2;
            String lcpLeft = longestCommonPrefix(strs, l, mid);
            String lcpRight = longestCommonPrefix(strs, mid + 1, r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    private static String commonPrefix(String left, String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i))
                return left.substring(0, i);
        }
        return left.substring(0, min);
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", ""}));

    }
}
