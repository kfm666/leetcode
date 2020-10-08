package leetcode;

/**
 * 反转链表
 */
public class SwordOffer24 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        print(node1);
        ListNode node = new SwordOffer24().reverseList(node1);
        print(node);
    }

    private static void print(ListNode node){
        while (node!= null){
            System.out.print(node.val+", ");
            node = node.next;
        }
        System.out.println();
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null,curr = head,next = null;
        while (curr != null){
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    /**
     * Definition for singly-linked list.
     */
     private static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

}
