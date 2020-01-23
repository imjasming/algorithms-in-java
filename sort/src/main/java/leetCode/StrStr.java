package leetCode;

/**
 * @author Xiaoming.
 * Created on 2019/09/28 20:18.
 */
public class StrStr {
    public static int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }

        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }

        final int bound = haystack.length() - needle.length() + 1;
        for (int i = 0; i < bound; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                boolean flag = true;
                for (int j = 1; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return i;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));
    }
}
