package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LowestCommonAncestor {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q);
    }

    private static TreeNode helper(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return null;
        }

        if (node == p || node == q) {
            return node;
        }

        TreeNode left = helper(node.left, p, q);
        TreeNode right = helper(node.left, p, q);

        if (left != null && right != null) {
            return node;
        }

        return (left == null) ? right : left;
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
        System.out.println(lowestCommonAncestor(root, root.left.left, root.left.right).val);
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
