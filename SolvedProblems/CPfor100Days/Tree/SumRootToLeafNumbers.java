package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class SumRootToLeafNumbers {
    public static int sumNumbers(TreeNode root) {
        return helper(root, 0, 0);
    }

    private static int helper(TreeNode node, int pathVal, int sum) {
        if (node == null) {
            return sum;
        }

        if (node.left == null && node.right == null) {
            return sum + (pathVal * 10 + node.val);
        }

        sum = helper(node.left, pathVal * 10 + node.val, sum);
        sum = helper(node.right, pathVal * 10 + node.val, sum);

        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        for (int i = 2; i <= 4; i++) {
            root.insert(i);
        }
        root.prettyDisplay(root);
        System.out.println(sumNumbers(root));
    }
}

// Tree Implementation
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

    // Insert method to insert values in tree in level order
    public void insert(int value) {
        TreeNode node = new TreeNode(value);
        if (this.val == 0) {
            this.val = value;
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(this);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current.left == null) {
                current.left = node;
                break;
            } else if (current.right == null) {
                current.right = node;
                break;
            } else {
                queue.add(current.left);
                queue.add(current.right);
            }
        }
    }

    // Display method to print tree in tree format
    public void prettyDisplay(TreeNode root) {
        display(root, 0);
    }

    private void display(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        display(node.right, level + 1);
        if (level != 0) {
            for (int i = 0; i < level; i++) {
                System.out.print("|\t");
            }
            System.out.println("|---->" + node.val);
        } else {
            System.out.println(node.val);
        }
        display(node.left, level + 1);
    }
}
