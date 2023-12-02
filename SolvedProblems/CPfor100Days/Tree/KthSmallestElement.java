package CPfor100Days.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class KthSmallestElement {
    static int count = 0;

    public static int kthSmallest(TreeNode root, int k) {
        return helper(root, k).val;
    }

    private static TreeNode helper(TreeNode node, int k) {
        if (node == null) {
            return null;
        }

        TreeNode left = helper(node.left, k);
        if (left != null) {
            return left;
        }
        count++;

        if (count == k) {
            return node;
        }

        return helper(node.right, k);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.insert(1);
        root.insert(2);
        root.insert(3);
        root.insert(5);
        root.insert(6);
        root.insert(7);
        root.insert(8);
        System.out.println(kthSmallest(root, 3));
        root.prettyDisplay(root);
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
