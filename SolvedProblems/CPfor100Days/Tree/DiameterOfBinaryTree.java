package CPfor100Days.Tree;

public class DiameterOfBinaryTree {
    public static int diameterOfBinaryTree(TreeNode root) {
        int[] arr = new int[1];
        depth(root, arr);
        return arr[0];
    }

    private static int depth(TreeNode root, int[] arr) {
        if(root == null) {
            return 0;
        }

        int leftHeight = depth(root.left, arr);
        int rightHeight = depth(root.right, arr);
        
        arr[0] = Math.max(arr[0], leftHeight + rightHeight);
        
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, null);
        root.left = new TreeNode(1, null, null);
        root.right = new TreeNode(3, null, null);
        root.left.left = new TreeNode(4, null, null);
        root.left.right = new TreeNode(5, null, null);

        int result = diameterOfBinaryTree(root);
        System.out.println(result);
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
