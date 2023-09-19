package Tree;

import java.util.ArrayList;

public class ValidBST {
    ArrayList<Integer> list = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        helper(root);

        for (int i = 0; i < list.size() - 1; i++) {
            if(list.get(i) > list.get(i + 1)){
                return false;
            }
        }

        return true;
    }

    private void helper(TreeNode node) {
        if(node == null){
            return;
        }

        helper(node.left);
        list.add(node.val);
        helper(node.right);

    }

    public static void main(String[] args) {

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
