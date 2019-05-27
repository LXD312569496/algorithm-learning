package array;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 */
public class mergeKLists {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String args[]) {
        ListNode p1=new ListNode(1);
        ListNode p2=new ListNode(4);
        ListNode p3=new ListNode(5);

        ListNode p4=new ListNode(1);
        ListNode p5=new ListNode(3);
        ListNode p6=new ListNode(4);

        ListNode p7=new ListNode(2);
        ListNode p8=new ListNode(6);

        p1.next=p2;
        p2.next=p3;
        p3.next=null;

        p4.next=p5;
        p5.next=p6;
        p6.next=null;

        p7.next=p8;
        p8.next=null;

        ListNode[] a1={p1,p4,p7};
        ListNode head = mergeKLists(a1);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    /**
     * 方法一：利用之前两两合并的方法
     * 方法二：利用优先级队列
     *
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists==null||lists.length==0){
            return null;
        }

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val > o2.val) {
                    return 1;
                } else if (o1.val == o2.val) {
                    return 0;
                }
                return -1;
            }
        });

        for (ListNode node : lists) {
            if (node!=null){
                priorityQueue.add(node);
            }
        }

        ListNode head = new ListNode(0);
        ListNode p=head;
        while (priorityQueue.size() > 0) {
            ListNode node = priorityQueue.poll();
            p.next = node;
            if (node.next != null) {
                priorityQueue.add(node.next);
            }
            p = p.next;
        }
        return head.next;
    }
}