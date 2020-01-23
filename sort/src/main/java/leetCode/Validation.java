package leetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author Xiaoming.
 * Created on 2019/08/10 21:30.
 */
public class Validation {
    private static final Map<Character, Character> MAPPING = new HashMap<>();

    static {
        MAPPING.put('(', ')');
        MAPPING.put(')', '(');
        MAPPING.put('[', ']');
        MAPPING.put(']', '[');
        MAPPING.put('{', '}');
        MAPPING.put('}', '{');
    }

    public static boolean matchBrackets_self(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }

        LinkedList<Character> stack = new LinkedList<>();

        for (Character c : s.toCharArray()) {
            if (!stack.isEmpty() && MAPPING.get(c) == stack.getFirst()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(matchBrackets_self("{}{[]}"));
    }
}
