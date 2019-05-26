package array;

/**
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class reverseList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

    }


    public ListNode reverseList(ListNode head) {
        ListNode result = null;

        ListNode pre = null;
        ListNode p = head;

        while (p != null) {
            ListNode next = p.next;

            if (next == null) {
                result = p;
            }

            p.next=pre;
            pre=p;

            p=next;
        }


        return result;
    }
}
