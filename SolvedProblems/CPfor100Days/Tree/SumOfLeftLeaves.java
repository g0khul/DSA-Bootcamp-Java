package CPfor100Days.Tree;

import java.util.Stack;

public class SumOfLeftLeaves {
    public  static int sumOfLeftLeaves(TreeNode root) {
        return helper(root, 0);
    }

    public static int helper(TreeNode node, int Sum) {
        Stack<TreeNode> stack = new Stack<>();
        boolean left = false;
        stack.add(node);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();

            if (current.left == null && current.right == null && left) {
                Sum = Sum + current.val;
                left = false;
            }

            if (current.right != null) {
                stack.push(current.right);
                left = false;
            }

            if (current.left != null) {
                stack.push(current.left);
                left = true;
            }
        }
        return Sum;
    }

    public static void main(String[] args) {

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
