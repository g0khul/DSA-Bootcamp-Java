package CPfor100Days.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PathExistNodeToNode {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        for (int i = 2; i <= 10; i++) {
        root.insert(i);
        }

        root.prettyDisplay(root);
        System.out.println(countPaths(root, 6));
    }

    private static int countPaths(TreeNode root, int sum) {
        return helper(root, sum, new ArrayList<Integer>());
    }

    private static int helper(TreeNode node, int sum, ArrayList<Integer> path) {
        if(node == null){
            return 0;
        }

        path.add(node.val);
        int count =  0;
        int s = 0;
        for (int i = path.size() - 1; i >= 0; i--) {
            s += path.get(i);
            count = (s == sum) ? count + 1 : count;
        }

        count += helper(node.left, sum, path) + helper(node.right, sum, path);

        path.remove(path.size() - 1);
        return count;
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
