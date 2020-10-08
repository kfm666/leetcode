package leetcode;

public class Question21 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public ListNode setNext(ListNode next) {
            this.next = next;
            return next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    static class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode head = new ListNode(0);
            ListNode result = head;
            ListNode left = l1,right = l2;
            while (left != null || right != null){
                if(left != null && right != null){
                    if(left.val <= right.val){
                        head.next = left;
                        left = left.next;
                    }else{
                        head.next = right;
                        right = right.next;
                    }
                }else if(left == null){
                    head.next = right;
                    right = null;
                }else{
                    head.next = left;
                    left = null;
                }
                head = head.next;
            }
            return result.next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.setNext(new ListNode(2)).setNext(new ListNode(4));
        ListNode l2 = new ListNode(1);
        l2.setNext(new ListNode(3)).setNext(new ListNode(4));
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(new Solution().mergeTwoLists(l1,l2));
    }
}
