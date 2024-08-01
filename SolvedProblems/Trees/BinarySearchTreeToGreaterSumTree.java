public class BinarySearchTreeToGreaterSumTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);
        root.right.left = new TreeNode(5);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);

        bstToGst(root);
        root.prettyDisplay(root);
    }

    public static TreeNode bstToGst(TreeNode root) {
        helper(root);
        return root;
    }

    static int currSum = 0;

    public static void helper(TreeNode node) {
        if (node == null) {
            return;
        }

        helper(node.right);
        node.val += currSum;
        currSum = node.val;
        helper(node.left);
        return;
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
