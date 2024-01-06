public class TreeToDoublyLL {
    DLinkedList head;
    DLinkedList tail;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        for (int i = 2; i < 8; i++) {
            root.insert(i);
        }

        root.prettyDisplay(root);
        System.out.println();
        System.out.println();
        System.out.println();

        TreeToDoublyLL obj = new TreeToDoublyLL();
        obj.generateDLinkedList(root);
        if (obj.head != null)
            obj.head.display(obj.head);
    }

    public void generateDLinkedList(TreeNode root) {
        inorder(root);
    }

    public void inorder(TreeNode node) {
        if (node == null) {
            return;
        }

        inorder(node.left);

        DLinkedList newNode = new DLinkedList(node.val);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = tail.next;
        }

        inorder(node.right);
    }
}

class DLinkedList {
    int val;
    DLinkedList prev;
    DLinkedList next;

    DLinkedList(int val) {
        this.val = val;
    }

    void display(DLinkedList head) {
        if (head == null) {
            System.out.println("Nothing to display");
            return;
        }
        DLinkedList temp = head;
        while (temp != null) {
            System.out.print((temp.prev != null) ? (temp.prev.val) : ("null"));
            System.out.print(" <- " + temp.val + " -> ");
            System.out.println((temp.next != null)? (temp.next.val) : ("null"));

            temp = temp.next;
        }
    }
}

// Tree Implementation
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode next;

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
