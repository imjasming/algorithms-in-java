package interview.jd;

/**
 * @author Xiaoming.
 * Created on 2019/08/24 18:45.
 */


import java.util.Scanner;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    /*static String solution(String tString) {
        LinkedList<Character> stack = new LinkedList<>();
        for (char c: tString.toCharArray()){
            stack.add(c);
        }

        parseTree(stack, new TreeNode(tString.charAt(0)));
    }*/

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;

        String _input;
        try {
            _input = in.nextLine();
        } catch (Exception e) {
            _input = null;
        }

        /*res = solution(_input);
        System.out.println(res);*/
    }

   /* private static TreeNode parseTree(LinkedList<Character> stack, TreeNode p) {
        char c;

        int lastType = 0;
        for (int i = 0; i < stack.size(); i++) {
            c = stack.pop();
            if (Character.isDigit(c)) {
                if (lastType == 0) {
                    p.left = new TreeNode(c);
                } else if (lastType == 2) {
                    p.right = new TreeNode(c);
                }
                lastType = 1;
            } else if (c == ',') {
                lastType = 2;
            } else if (c == '(') {
                if (lastType == 0) {
                    parseTree(stack, p);
                }
                lastType = 0;
            }
        }

    }*/

    private static class TreeNode {
        char item;
        TreeNode left;
        TreeNode right;

        public TreeNode(char item) {
            this.item = item;
        }

        public TreeNode() {
        }
    }
}
