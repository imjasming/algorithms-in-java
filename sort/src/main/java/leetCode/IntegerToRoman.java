package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xiaoming.
 * Created on 2019/07/28 21:47.
 */
public class IntegerToRoman {
    public static String intToRoman(int num) {
        // 把阿拉伯数字与罗马数字可能出现的所有情况和对应关系，放在两个数组中
        // 并且按照阿拉伯数字的大小降序排列，这是贪心选择思想
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        while (index < 13) {
            // 特别注意：这里是等号
            while (num >= nums[index]) {
                // 注意：这里是等于号，表示尽量使用大的"面值"
                stringBuilder.append(romans[index]);
                num -= nums[index];
            }
            index++;
        }
        return stringBuilder.toString();
    }

    private static final String[] bit1 = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    private static final String[] bit10 = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private static final String[] bit100 = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private static final String[] bit1000 = {"", "M", "MM", "MMM"};

    public static String intToRoman_1(int num) {
        return new StringBuilder().append(bit1000[num / 1000]).append(bit100[num % 1000 / 100]).append(bit10[num % 100 / 10]).append(bit1[num % 10]).toString();
    }

    private static final Map<String, Integer> map = new HashMap<>();

    static {
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
    }

    public static int romanToInt(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); ) {
            if (i + 1 < s.length() && map.containsKey(s.substring(i, i + 2))) {
                ans += map.get(s.substring(i, i + 2));
                i += 2;
            } else {
                String sub = s.substring(i, i + 1);
                int j = map.get(sub);
                ans += j;
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String i, j;
        long t0 = System.nanoTime();
        j = intToRoman_1(2994);
        long t1 = System.nanoTime();
        i = intToRoman(2994);
        long t2 = System.nanoTime();
        System.out.println(t1 - t0 + "," + (t2 - t1));
        System.out.println(j + ", " + i + ", " + romanToInt("IV"));
    }
}
