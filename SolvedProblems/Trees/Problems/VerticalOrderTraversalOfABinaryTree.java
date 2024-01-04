// package Trees.Problems;

import java.util.List;
import java.util.Map;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrderTraversalOfABinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        for (int i = 2; i < 8; i++) {
            root.insert(i);
        }

        root.prettyDisplay(root);
        List<List<Integer>> result = verticalTraversal(root);
        System.out.println(result);
    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, Map<Integer, List<Integer>>> map = new TreeMap<>();
        helper(root, map, 0, 0);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> colKeys = new ArrayList<>(map.keySet());
        for (int colKey : colKeys) {
            Map<Integer, List<Integer>> innerMap = map.get(colKey);
            List<Integer> rowKeys = new ArrayList<>(innerMap.keySet());
            List<Integer> levelValues = new ArrayList<>();
            for (int rowKey : rowKeys) {
                List<Integer> value = innerMap.get(rowKey);
                Collections.sort(value);
                levelValues.addAll(value);
            }
            result.add(levelValues);
        }

        return result;
    }

    public static void helper(TreeNode node, Map<Integer, Map<Integer, List<Integer>>> map, int row, int col) {
        if (node == null) {
            return;
        }

        if (!map.containsKey(col)) {
            Map<Integer, List<Integer>> innerMap = new TreeMap<>() {
                {
                    put(row, new ArrayList<>(Arrays.asList(node.val)));
                }
            };
            map.put(col, innerMap);
        } else {
            Map<Integer, List<Integer>> innerMap = map.get(col);
            if (!innerMap.containsKey(row)) {
                innerMap.put(row, new ArrayList<>(Arrays.asList(node.val)));
            } else {
                List<Integer> values = innerMap.get(row);
                values.add(node.val);
                Collections.sort(values);
            }
        }

        helper(node.left, map, row + 1, col - 1);
        helper(node.right, map, row + 1, col + 1);
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
