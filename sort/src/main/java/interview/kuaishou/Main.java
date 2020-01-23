package interview.kuaishou;

/**
 * @author Xiaoming.
 * Created on 2019/09/16 19:27.
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();

        for (char c : s.toCharArray()) {
            if (c > '9' || c < '2') {
                return;
            }
        }

        combind("", s, 0);

        String r = res.toString();
        System.out.println(r);
    }

    private static HashMap<Character, String> mapper = new HashMap<>();

    static {
        mapper.put('2', "abc");
        mapper.put('3', "def");
        mapper.put('4', "ghi");
        mapper.put('5', "jkl");
        mapper.put('6', "mno");
        mapper.put('7', "pqrs");
        mapper.put('8', "tuv");
        mapper.put('9', "wxyz");

    }

    static LinkedList<String> res = new LinkedList<>();

    private static void combind(String s, String in, int index) {
        if (index >= in.length()) {
            res.add(s);
            return;
        }

        String map = mapper.get(in.charAt(index));

        for (int i = 0; i < map.length(); i++) {
            combind(s + map.charAt(i), in, index + 1);
        }
    }

    private static String ipType(String s) {
        if (s.indexOf(".") > 0) {
            if (isIPV4(s)) {
                return "IPv4";
            }
        } else if (s.indexOf(":") > 0) {
            if (isIPV6(s)) {
                return "IPv6";
            }
        }

        return "Neither";
    }

    private static boolean isIPV4(String s) {
        String[] addr = s.split(".");
        if (addr.length != 4) {
            return false;
        }
        int range = 0;
        for (String a : addr) {
            if (a.length() > 1 && a.charAt(0) == '0') {
                return false;
            }
            range = Integer.parseInt(a);
            if (range > 255 || range < 0) {
                return false;
            }
        }

        return true;
    }

    private static boolean isIPV6(String s) {
        String[] addr = s.split(":");
        if (addr.length != 8) {
            return false;
        }
        int num = 0;
        int upBound = 1 << 16;
        for (String a : addr) {
            if (a.length() > 4 || a.length() == 0) {
                return false;
            }

            for (char c : a.toLowerCase().toCharArray()) {
                if (Character.isAlphabetic(c) && c > 'f') {
                    return false;
                }
            }

            num = Integer.parseInt(a, 16);
            if (num > upBound || num < 0) {
                return false;
            }
        }

        return true;
    }
}