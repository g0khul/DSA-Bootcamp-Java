import java.util.Stack;

public class BSTIterator {

    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();

        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode result = stack.pop();
        TreeNode current = result.right;

        while (current != null) {
            stack.push(current);
            current = current.left;
        }

        return result.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
