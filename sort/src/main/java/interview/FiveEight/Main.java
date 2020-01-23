package interview.FiveEight;

/**
 * @author Xiaoming.
 * Created on 2019/09/12 21:02.
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();

        Map ans = findMaxChar(s);
        System.out.println(ans.get("char") + " " + ans.get("num"));
    }

    private static class BigInt {
        int h;
        int l;
    }

    private static String bigIntAdd(String s1, String s2) {
        return null;
    }

    private static Map findMaxChar(String s) {
        int[] map = new int[256];

        for (char c : s.toCharArray()) {
            map[c]++;
        }

        int ans = -1;
        int max = 0, num;
        for (int i = 0; i < map.length; i++) {
            num = (char) map[i];
            if (num > max) {
                max = num;
                ans = i;
            }
        }

        Map<String, String> res = new HashMap<>();
        res.put("char", (char) ans + "");
        res.put("num", max + "");

        return res;
    }

    private static boolean isBalance(String s) {
        LinkedList<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.size() > 0) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.size() == 0;
    }
}