package array;


import java.util.List;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
class mergeTwoLists {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(4);
        p1.next = p2;
        p2.next = p3;
        p3.next = null;

        ListNode p4 = new ListNode(1);
        ListNode p5 = new ListNode(3);
        ListNode p6 = new ListNode(4);
        p4.next = p5;
        p5.next = p6;
        p6.next = null;

        ListNode head = mergeTwoLists(p1, p4);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head;
        ListNode result;
        ListNode p1 = l1;
        ListNode p2 = l2;

        if (l1.val > l2.val) {
            result = p2;
            p2 = p2.next;
        } else {
            result = p1;
            p1 = p1.next;
        }

        head = result;

        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                result.next = p1;
                result = result.next;
                p1 = p1.next;
            } else {
                result.next = p2;
                result = result.next;
                p2 = p2.next;
            }
        }

        if (p1 != null) {
            result.next = p1;
        }

        if (p2 != null) {
            result.next = p2;
        }
        return head;
    }


    /**
     * 利用递归的方式实现
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode result;

        if (l1.val > l2.val) {
            result = l2;
            l2 = l2.next;
            result.next = mergeTwoLists(l1, l2);
        } else {
            result = l1;
            l1 = l1.next;
            result.next = mergeTwoLists(l1, l2);
        }

        return result;
    }

}
