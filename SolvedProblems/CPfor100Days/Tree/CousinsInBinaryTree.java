package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class CousinsInBinaryTree {
    // public boolean isCousins(TreeNode root, int x, int y) {
    // if (root == null) {
    // return false;
    // }

    // Queue<TreeNode> queue = new LinkedList<>();
    // queue.offer(root);

    // while (!queue.isEmpty()) {
    // int size = queue.size();
    // boolean markx = false;
    // boolean marky = false;

    // for (int i = 0; i < size; i++) {
    // TreeNode currNode = queue.poll();

    // if (currNode.val == x) {
    // markx = true;
    // }

    // if (currNode.val == y) {
    // marky = true;
    // }

    // if (currNode.left != null) {
    // queue.offer(currNode.left);
    // }

    // if (currNode.right != null) {
    // queue.offer(currNode.right);
    // }
    // }

    // if (markx && marky) {
    // return (!isSibiling(root, x, y)) ? true : false;
    // }
    // }

    // return false;
    // }

    // private boolean isSibiling(TreeNode root, int x, int y) {
    // Queue<TreeNode> queue = new LinkedList<>();
    // queue.offer(root);

    // while (!queue.isEmpty()) {
    // TreeNode currNode = queue.poll();

    // if ((currNode.left != null && currNode.right != null)
    // && ((currNode.left.val == x && currNode.right.val == y)
    // || (currNode.left.val == y && currNode.right.val == x))) {
    // return true;
    // }

    // if (currNode.left != null) {
    // queue.offer(currNode.left);
    // }

    // if (currNode.right != null) {
    // queue.offer(currNode.right);
    // }
    // }

    // return false;
    // }

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }

        TreeNode xx = findNode(root, x);
        TreeNode yy = findNode(root, y);

        return level(root, xx, 0) == level(root, yy, 0) && !isSibiling(root, xx, yy);
    }

    private int level(TreeNode node, TreeNode x, int level) {
        if (node == null) {
            return 0;
        }

        if (node == x) {
            return level;
        }

        int l = level(node.left, x, level + 1);
        if (l != 0) {
            return l;
        }

        return level(node.right, x, level + 1);
    }

    private boolean isSibiling(TreeNode node, TreeNode x, TreeNode y) {
        if (node == null) {
            return false;
        }

        return (node.left == x && node.right == y) || (node.left == x && node.right == y) || isSibiling(node.left, x, y)
                || isSibiling(node.right, x, y);
    }

    private TreeNode findNode(TreeNode node, int v) {
        if (node == null) {
            return null;
        }

        if (node.val == v) {
            return node;
        }

        TreeNode n = findNode(node.left, v);
        if (n != null) {
            return n;
        }

        return findNode(node.right, v);
    }
}
