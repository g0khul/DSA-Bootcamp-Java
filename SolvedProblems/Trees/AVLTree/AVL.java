package Trees.AVLTree;

public class AVL {
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
        return rotate(node);
    }

    private Node rotate(Node node) {
        if (height(node.left) - height(node.right) > 1) {
            // Left heavy
            if (height(node.left.left) - height(node.left.right) > 0) {
                // Left left case
                return rightRotate(node);
            }

            // Right heavy
            if (height(node.left.left) - height(node.left.right) < 0) {
                // Left right case
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if (height(node.left) - height(node.right) < -1) {
            // Right heavy
            if (height(node.right.left) - height(node.right.right) < 0) {
                // Right right case
                return leftRotate(node);
            }

            if (height(node.right.left) - height(node.right.right) > 0) {
                // Right left case
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }

    private Node rightRotate(Node p) {
        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;

        p.height = Math.max(height(p.left), height(p.right) + 1);
        c.height = Math.max(height(c.left), height(c.right) + 1);

        return c;
    }

    private Node leftRotate(Node p) {
        Node c = p.right;
        Node t = c.left;

        c.left = p;
        p.right = t;

        p.height = Math.max(height(p.left), height(p.right) + 1);
        c.height = Math.max(height(c.left), height(c.right) + 1);

        return c;
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

}
