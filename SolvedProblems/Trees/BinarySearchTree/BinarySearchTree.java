package SolvedProblems.Trees.BinarySearchTree;

public class BinarySearchTree {
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

    // With node as return type
    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            root = insert(root, value);
        }
    }

    private Node insert(Node node, int value) {
        if (node == null) {
            node = new Node(value);
            return node;
        }
        if (value < node.value) {
            // Travel at the left side
            node.left = insert(node.left, value);
        }

        if (value > node.value) {
            // Travel at the right side
            node.right = insert(node.right, value);
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    // Insert values in an array which is sorted by not using self balancing tree
    // like AVL tree
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

    public boolean isEmpty() {
        return root == null;
    }

    public boolean balanced() {
        return balanced(root);
    }

    private boolean balanced(Node node) {
        if (node == null) {
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.value + " ");
        // Going to the left side
        preOrder(node.left);

        // Going to the right side
        preOrder(node.right);

    }

    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node){
        if(node == null){
            return;
        }

        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);

    }

    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node){
        if(node == null){
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

}
