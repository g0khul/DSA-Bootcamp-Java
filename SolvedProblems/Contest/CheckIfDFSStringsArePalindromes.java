import java.util.*;

public class CheckIfDFSStringsArePalindromes {
    public static void main(String[] args) {
        int[] parent = { -1, 9, 7, 13, 14, 12, 3, 13, 11, 12, 12, 15, 16, 10, 0, 14, 15 };
        System.out.println(parent.length);
        String s = "ifdhhfdhikfiedhdh";
        boolean[] result = findAnswer(parent, s);
        System.out.println(Arrays.toString(result));
    }

    public static boolean[] findAnswer(int[] parent, String s) {
        TreeNode[] trees = constructTree(parent, s);
        boolean[] result = new boolean[parent.length];

        for (int i = 0; i < parent.length; i++) {
            String dfsStr = dfs(i, "", trees[i]);
            System.out.println(dfsStr);
            if (isPalindrome(dfsStr)) {
                result[i] = true;
            }
        }

        return result;
    }

    public static String dfs(int x, String dfsStr, TreeNode node) {
        dfsStr += node.alphabet;

        if (node.left != null && node.right != null) {
            if (node.left.value < node.right.value) {
                dfsStr = dfs(node.left.value, dfsStr, node.left);
            } else {
                dfsStr = dfs(node.right.value, dfsStr, node.right);
            }
        } else if (node.left != null) {
            dfsStr = dfs(node.left.value, dfsStr, node.left);
        } else if (node.right != null) {
            dfsStr = dfs(node.right.value, dfsStr, node.right);
        }

        return dfsStr;
    }

    public static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public static TreeNode[] constructTree(int[] parent, String s) {
        TreeNode[] trees = new TreeNode[parent.length];
        Arrays.fill(trees, null);
        trees[0] = new TreeNode(0, s.charAt(0));

        for (int i = 1; i < parent.length; i++) {
            int p = parent[i];
            char c = s.charAt(i);
            TreeNode pt = trees[p];

            if (pt == null) {
                pt = new TreeNode(p, s.charAt(p));
                trees[p] = pt;
            }

            if (pt.left == null) {
                if (trees[i] != null) {
                    pt.left = trees[i];
                } else {
                    pt.left = new TreeNode(i, c);
                    trees[i] = pt.left;
                }
            } else if (pt.right == null) {
                if (trees[i] != null) {
                    pt.right = trees[i];
                } else {
                    pt.right = new TreeNode(i, c);
                    trees[i] = pt.right;
                }
            }
        }

        for (TreeNode treeNode : trees) {
            System.out.println(treeNode.value + " : " + treeNode.alphabet);
            if (treeNode.left != null)
                System.out.println("Left : " + treeNode.left.value);
            if (treeNode.right != null)
                System.out.println("Right : " + treeNode.right.value);
        }

        return trees;
    }
}

class TreeNode {
    int value;
    char alphabet;
    TreeNode left;
    TreeNode right;

    TreeNode(int value, char alphabet) {
        this.value = value;
        this.alphabet = alphabet;
    }
}
