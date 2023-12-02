package Trees.Problems;

public class Tree {
    Node root;

    public void populate(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            populate(root, value);
        }
    }

    private void populate(Node node, int value) {

        if (value < node.value) {
            if (node.left == null) {
                node.left = new Node(value);
                return;
            }
            // Travel at the left side
            populate(node.left, value);
            return;
        }

        if (value > node.value) {
            if (node.right == null) {
                node.right = new Node(value);
                return;
            }
            // Travel at the right side
            populate(node.right, value);
            return;
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;

    }

    public void insert(int[] arr) {
        insert(arr, 0, arr.length - 1);
    }

    private void insert(int[] arr, int start, int end) {
        if (start > end) {
            return;
        }

        int mid = (start + end) / 2;
        populate(arr[mid]);
        insert(arr, start, mid);
        insert(arr, mid + 1, end);
    }

    private int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public void display() {
        prettyDisplay(root, 0);
    }

    private void prettyDisplay(Node node, int level) {
        if (node == null) {
            return;
        }

        prettyDisplay(node.right, level + 1);
        if (level != 0) {
            for (int i = 0; i < level; i++) {
                System.out.print("|\t");
            }
            System.out.println("|---->" + node.value);
        } else {
            System.out.println(node.value);
        }
        prettyDisplay(node.left, level + 1);

    }

}
