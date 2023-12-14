package CPfor100Days.Tree;

import java.util.Arrays;
import java.util.HashMap;

public class ConstructBinaryTree {
    public static TreeNode buildTreeBetterWay(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        int[] preIndex = { 0 };

        return helper(preorder, inorder, 0, inorder.length - 1, map, preIndex);
    }

    public static TreeNode helper(int[] preorder, int[] inorder, int start, int end, HashMap<Integer, Integer> map,
            int[] preIndex) {
        if (start > end) {
            return null;
        }

        int currIndex = preIndex[0];

        TreeNode node = new TreeNode(preorder[currIndex]);
        preIndex[0]++;

        if (start == end) {
            return node;
        }

        node.left = helper(preorder, inorder, start, map.get(preorder[currIndex]) - 1, map, preIndex);
        node.right = helper(preorder, inorder, map.get(preorder[currIndex]) + 1, end, map, preIndex);

        return node;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        int r = preorder[0];
        int index = 0;

        for (; index < inorder.length; index++) {
            if (r == inorder[index]) {
                break;
            }
        }

        TreeNode node = new TreeNode(r);
        node.left = buildTree(Arrays.copyOfRange(preorder, 1, index + 1), Arrays.copyOfRange(inorder, 0, index));
        node.right = buildTree(Arrays.copyOfRange(preorder, index + 1, preorder.length),
                Arrays.copyOfRange(inorder, index + 1, inorder.length));

        return node;
    }

    public static void main(String[] args) {
        int[] preorder = { 1, 2, 4, 8, 9, 5, 3, 6, 7 };
        int[] inorder = { 8, 4, 9, 2, 5, 1, 6, 3, 7 };
        TreeNode root = buildTreeBetterWay(preorder, inorder);
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
