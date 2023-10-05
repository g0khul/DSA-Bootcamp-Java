package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeMaximumPathSum {
    public static int maxPathSum(TreeNode root) {
        helper(root);
        return maxPath;
    }

    static int maxPath = Integer.MIN_VALUE;

    private static int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = helper(node.left);
        int right = helper(node.right);

        left = Math.max(left, 0);
        right = Math.max(right, 0);

        int pathSum = node.val + left + right;
        maxPath = Math.max(maxPath, pathSum);

        return Math.max(left, right) + node.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.insert(9);
        root.insert(20);
        root.insert(Integer.MIN_VALUE);
        root.insert(Integer.MIN_VALUE);
        root.insert(15);
        root.insert(7);

        // for (int i = 2; i <= 4; i++) {
        // root.insert(i);
        // }
        root.prettyDisplay(root);
        System.out.println(maxPathSum(root));
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
