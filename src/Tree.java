import java.util.Stack;

public class Tree {
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    static class Solution {

        public void Mirror(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while(!stack.empty()){
                TreeNode node = stack.pop();
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
                if(node.left != null){
                    stack.push(node.left);
                }
                if(node.right != null){
                    stack.push(node.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        
    }
}
