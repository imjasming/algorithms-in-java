package interview.dangdang;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Xiaoming.
 * Created on 2019/09/28 14:34.
 */
public class Main {
    private static final Map<Character, String> MAPPER = new HashMap<>();

    static {
        MAPPER.put('1', "abc");
        MAPPER.put('2', "def");
        MAPPER.put('3', "ghi");
        MAPPER.put('4', "jkl");
        MAPPER.put('5', "mno");
        MAPPER.put('6', "pqr");
        MAPPER.put('7', "stu");
        MAPPER.put('8', "vwx");
        MAPPER.put('9', "yz");

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ns = in.next();

        LinkedList<String> ans = new LinkedList<>();
        expandOutput(ans, ns, "", 0);

        String res = ans.toString().replace(" ", "");
        System.out.println(res.substring(1, res.length() - 1));
    }

    private static void expandOutput(LinkedList<String> ans, String in, String res, int index) {
        if (index == in.length()) {
            ans.add(res);
            return;
        }

        for (Character c : MAPPER.get(in.charAt(index)).toCharArray()) {
            expandOutput(ans, in, res + c, index + 1);
        }
    }
}
