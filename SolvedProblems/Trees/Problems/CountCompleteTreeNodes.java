import java.util.Queue;
import java.util.LinkedList;

public class CountCompleteTreeNodes {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        for (int i = 2; i < 9; i++) {
            root.insert(i);
        }

        root.prettyDisplay(root);

        System.out.println(countNodes(root));
    }

    public static int countingNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int n = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            n += size;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return n;
    }

    public static int countNodes(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = findLeftHeight(node.left);
        int rightHeight = findRightHeight(node.right);

        if (leftHeight == rightHeight) {
            return (2 << leftHeight) - 1;
        }

        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    public static int findLeftHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return 1 + findLeftHeight(node.left);
    }

    public static int findRightHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return 1 + findRightHeight(node.right);
    }
}

// Tree Implementation
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode next;

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