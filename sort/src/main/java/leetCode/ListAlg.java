package leetCode;

/**
 * @author Xiaoming.
 * Created on 2019/07/20 14:53.
 */
public class ListAlg {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode h = null, c, p = null, n1 = l1, n2 = l2;
        int overflow = 0;

        while (n1 != null && n2 != null) {
            c = new ListNode(0);
            if (h == null) {
                h = c;
            } else {
                p.next = c;
            }

            int sum = n1.val + n2.val + overflow;
            if (sum >= 10) {
                c.val = sum % 10;
                overflow = 1;
            } else {
                c.val = sum;
                overflow = 0;
            }

            p = c;

            n1 = n1.next;
            n2 = n2.next;
        }

        ListNode tail = n1 != null ? n1 : n2;

        while (tail != null) {
            c = new ListNode(tail.val + overflow);
            p.next = c;

            if (c.val >= 10) {
                c.val %= 10;
                overflow = 1;
            } else {
                overflow = 0;
            }
            p = c;
            tail = tail.next;
        }
        if (overflow == 1) {
            c = new ListNode(1);
            p.next = c;
        }

        return h;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null, c, p = null, c1 = l1, c2 = l2;

        while (c1 != null || c2 != null) {
            if (c1 == null || (c2 != null && c2.val < c1.val)) {
                c = new ListNode(c2.val);
                c2 = c2.next;
            } else {
                c = new ListNode(c1.val);
                c1 = c1.next;
            }
            if (head == null) {
                head = c;
            } else {
                p.next = c;
            }

            p = c;
        }

        return head;
    }

}
