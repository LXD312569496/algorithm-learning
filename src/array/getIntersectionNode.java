package array;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 */
public class getIntersectionNode {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

    }


    /**
     * 简洁一点的方法：让结点向后走，当一个链表走完，让它这个结点指向另一个节点的头部；
     * 另一个走完，指向另一个结点的头部，这样就消除了长度差：第二次循环的时候就可以一起走到相交结点
     */
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? pB : pA.next;
            pB = pB == null ? pA : pB.next;
        }
        return pA;
    }


    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);
        ListNode slow;//慢走
        ListNode fast;//先走
        if (lengthA > lengthB) {
            slow = headB;
            fast = headA;
        } else {
            slow = headA;
            fast = headB;
        }
        int diff = Math.abs(lengthA - lengthB);
        while (diff > 0) {
            fast = fast.next;
            diff--;
        }

        while (slow != null && fast != null) {
            if (slow == fast) {
                return slow;
            }
            slow = slow.next;
            fast = fast.next;
        }

        return null;
    }

    public static int getLength(ListNode headA) {
        ListNode p = headA;
        int length = 0;
        while (p != null) {
            p = p.next;
            length++;
        }
        return length;
    }
}
