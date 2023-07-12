// https://leetcode.com/problems/maximum-depth-of-binary-tree/
package SolvedProblems.CPfor100Days;

import java.util.ArrayList;

public class MaxDepthTree {
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.insert(1);
        root.insert(2);
        root.insert(2);
        // root.insert(3);
        root.insert(4);
        root.insert(4);
        root.insert(3);
        root.prettyDisplay(root);
        System.out.println(maxDepth(root));

    }
}

class Solution {
    ArrayList<Integer> list = new ArrayList<>();

    public int maxDepth(TreeNode root) {
        findLevels(root, 0);
        return findMax();
    }

    public void findLevels(TreeNode node, int level){
        if(node == null){
            list.add(level);
            return;
        }

        // Go to left
        findLevels(node.left, level + 1);

        // Go to right
        findLevels(node.right, level + 1);
    } 

    public int findMax(){
        int max = list.get(0);
        for(int i : list){
            if(max < i){
                max = i;
            }
        }
        return max;
    }
}
