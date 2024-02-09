public class MinimumAbsoluteDifferenceInBST {

    TreeNode prev = null;
    int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        return helper(root);
    }

    public int helper(TreeNode node) {
        if (node == null) {
            return min;
        }

        min = helper(node.left, min);

        if (prev != null) {
            min = Math.min(min, Math.abs(prev.val - node.val));
        }

        prev = node;

        min = helper(node.right, min);

        return min;
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
