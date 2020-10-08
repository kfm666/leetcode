package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 * 589. N叉树的前序遍历
 */
public class Leetcode589 {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.children = Arrays.asList(node3,node2,node4);
        node3.children = Arrays.asList(node5,node6);
        System.out.println(preorder(node1));
        System.out.println(iteration(node1));
    }


    public static List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        recursion(root,result);
        return result;
    }

    /**
     * 递归解法
     * @param root
     * @param result
     */
    private static void recursion(Node root,List<Integer> result){
        result.add(root.val);
        if(root.children == null){
            return ;
        }
        for(Node node : root.children){
            recursion(node, result);
        }
    }

    /**
     * 迭代解法，用栈
     * @param root
     * @return
     */
    private static List<Integer> iteration(Node root){
        LinkedList<Node> nodes = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        nodes.addLast(root);
        while (nodes.size() > 0){
            Node node = nodes.pollLast();
            if(node == null){
                continue;
            }
            result.add(node.val);
            if(node.children == null){
                continue;
            }
            for(int i = node.children.size() - 1; i>=0; i--){
                nodes.addLast(node.children.get(i));
            }
        }
        return result;
    }


    // Definition for a Node.
    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
