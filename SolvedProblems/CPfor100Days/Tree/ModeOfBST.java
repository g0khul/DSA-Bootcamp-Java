package CPfor100Days.Tree;

import java.util.ArrayList;
import java.util.List;

public class ModeOfBST {
    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);

        if(list.size() == 0){
            return new int[] {0};
        }
        
        int arr[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }

    private void helper(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }   

        if (node.left != null && node.val == node.left.val && !list.contains(node.val)) {
            list.add(node.val);
        }

        helper(node.left, list);

        if (node.right != null && node.val == node.right.val && !list.contains(node.val)) {
            list.add(node.val);
        }

        helper(node.right, list);
    }
}
