package CPfor100Days.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ZigZagLevelOrder {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerFirst(root);
        boolean flag = false; // False indicates left to right

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelAns = new LinkedList<>();

            for (int i = 0; i < levelSize; i++) {
                // Left to right removal
                if (!flag) {
                    TreeNode currentNode = queue.pollFirst();
                    levelAns.add(currentNode.val);

                    if (currentNode.left != null) {
                        queue.offerLast(currentNode.left);
                    }

                    if (currentNode.right != null) {
                        queue.offerLast(currentNode.right);
                    }
                } else { // Right to left removal
                    TreeNode currentNode = queue.pollLast();
                    levelAns.add(currentNode.val);

                    if (currentNode.right != null) {
                        queue.offerFirst(currentNode.right);
                    }

                    if (currentNode.left != null) {
                        queue.offerFirst(currentNode.left);
                    }
                }
            }

            flag = !flag;
            result.add(levelAns);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.right.left.left = new TreeNode(10);
        root.right.left.right = new TreeNode(11);

        System.out.println(zigzagLevelOrder(root));
    }
}
