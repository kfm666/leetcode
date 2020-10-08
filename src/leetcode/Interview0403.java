package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/list-of-depth-lcci/
 */
public class Interview0403 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node7;
        node4.left = node8;
        ListNode[] nodes = new Interview0403().listOfDepth(node1);
        for(ListNode node : nodes){
            print(node);
        }
    }

    public ListNode[] listOfDepth(TreeNode tree) {
        ArrayList<ListNode> nodes = new ArrayList<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        ListNode node = null;
        // 记录每层的首节点
        TreeNode first = tree;
        list.addLast(tree);
        while (list.size() > 0){
            TreeNode treeNode = list.pop();
            if(first == treeNode){
                first = null;
                node = null;
            }
            if(node == null){
                node = new ListNode(treeNode.val);
                nodes.add(node);
            }else {
                node.next = new ListNode(treeNode.val);
                node = node.next;
            }
            if(treeNode.left != null){
                list.addLast(treeNode.left);
                if(first == null){
                    first = treeNode.left;
                }
            }
            if(treeNode.right != null){
                list.addLast(treeNode.right);
                if(first == null){
                    first = treeNode.right;
                }
            }

        }
        return nodes.toArray(new ListNode[]{});
    }

    private static void print(ListNode node){
        while (node!= null){
            System.out.print(node.val+", ");
            node = node.next;
        }
        System.out.println();
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
