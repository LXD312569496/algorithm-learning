package array;
/**
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 * <p>
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */
public class sortList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(4);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(1);
        ListNode p4 = new ListNode(3);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next=null;

        ListNode head = sortList(p1);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode sortList(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode first=head;
        ListNode second=head;

        ListNode p1=head,p2=head.next;
        while (p2!=null&&p2.next!=null){
            p1=p1.next;
            p2=p2.next.next;
        }
        //中间的位置
        second=p1.next;
        p1.next=null;

        first=sortList(first);
        second=sortList(second);

        return mergeTwoLists(first,second);
    }

    /**
     * 利用递归的方式实现
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
