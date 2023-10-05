package Tree;

import java.util.LinkedList;
import java.util.Queue;

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "$,";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.val + ",");
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] str = data.split(",");
        return helper(str);
    }

    int index = 0;
    private TreeNode helper(String[] value) {
        if (index >= value.length) {
            return null;
        }

        if (value[index].equals("$")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(value[index]));
        index++;
        root.left = helper(value);
        index++;
        root.right = helper(value);

        return root;
    }
}

public class SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
        Codec ser = new Codec();
        Codec deser = new Codec();

        TreeNode root = new TreeNode(1);
        for (int i = 2; i <= 10; i++) {
            root.insert(i);
        }
        root.prettyDisplay(root);
        String serialize = ser.serialize(root);
        System.out.println(serialize);
        TreeNode ans = deser.deserialize(serialize);
        ans.prettyDisplay(ans);
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
