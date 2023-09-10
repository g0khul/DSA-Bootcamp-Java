import Tree.TreeNode;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root, targetSum);
    }

    private boolean helper(TreeNode node, int targetSum) {
        if (node == null) {
            return false;
        }

        if (node.left == null && node.right == null) {
            return node.val == targetSumRe;
        }

        return helper(node.left, targetSum - node.val) || helper(node.right, targetSum - node.val);
    }

}
