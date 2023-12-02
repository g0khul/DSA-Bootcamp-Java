package CPfor100Days.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class PathExistRootToLeaf {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        for (int i = 2; i <= 10; i++) {
        root.insert(i);
        }

        root.prettyDisplay(root);
        int[] path = {1,2,5,10};

        System.out.println(pathExist(root, path));
    }

    private static boolean pathExist(TreeNode root, int[] path) {
        return helper(root, path, 0);
    }

    private static boolean helper(TreeNode node, int[] path, int i) {
        if(node == null){
            return i == path.length;
        }

        if(i >= path.length || node.val != path[i]){
            return false;
        }

        return helper(node.left, path, i + 1) || helper(node.right, path, i + 1);
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
