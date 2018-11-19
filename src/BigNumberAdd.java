/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 单位 数字。
 * 如果，我们将这两个数起来相加起来，则会返回出一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */

public class BigNumberAdd {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(4);

        ListNode node4 = new ListNode(9);
        ListNode node5 = new ListNode(9);
        ListNode node6 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;

        node4.next = node5;
        node5.next = node6;

        //调用方法
        ListNode result = addTwoNumbers(node1, node4);
        //输出结果
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //第一个节点是头结点
        ListNode head = new ListNode(0);
        ListNode p = head;

        ListNode p1 = l1;
        ListNode p2 = l2;
        boolean flag = false;//是否进位的标志
        while (p1 != null || p2 != null) {
            int number1 = p1!=null?p1.val:0;
            int number2 = p2!=null?p2.val:0;
            int result = number1 + number2;
            if (flag) {
                result = result + 1;
            }
            if (result >= 10) {
                flag = true;
                result = result - 10;
            } else {
                flag = false;
            }

            ListNode listNode = new ListNode(result);
            p.next = listNode;
            p = listNode;

            if (p1!=null)p1 = p1.next;
            if (p2!=null)p2 = p2.next;
        }

        if (flag) {
            ListNode listNode = new ListNode(1);
            p.next = listNode;
        }
        return head.next;
    }
}
