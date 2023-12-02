package Trees.SegmentTree;

// Node implementation of Segment Tree
class Node {
    int data; // here I'm finding the sum
    int startInterval;
    int endInterval;
    Node left;
    Node right;

    public Node(int startInterval, int endInterval) {
        this.startInterval = startInterval;
        this.endInterval = endInterval;
    }
}

// Segment tree method implementations
public class SegmentTree {
    Node root;

    SegmentTree(int[] nums) {
        this.root = createTree(nums, 0, nums.length - 1);
    }

    private Node createTree(int[] nums, int start, int end) {
        if (start == end) {
            Node leaf = new Node(start, end);
            leaf.data = nums[start];
            return leaf;
        }

        Node newNode = new Node(start, end);

        int mid = start + (end - start) / 2;
        newNode.left = this.createTree(nums, start, mid);
        newNode.right = this.createTree(nums, mid + 1, end);
        newNode.data = newNode.left.data + newNode.right.data;

        return newNode;
    }

    int query(int start, int end) {
        return helperQuery(this.root, start, end);
    }

    private int helperQuery(Node node, int queryStart, int queryEnd) {
        if (node.startInterval >= queryStart && node.endInterval <= queryEnd) {
            return node.data;
        }

        if (node.startInterval > queryEnd || node.endInterval < queryStart) {
            return 0;
        }

        int leftAns = this.helperQuery(node.left, queryStart, queryEnd);
        int rightAns = this.helperQuery(node.right, queryStart, queryEnd);
        return leftAns + rightAns;
    }

    void update(int index, int value) {
        this.root.data = helperUpdate(this.root, index, value);
    }

    private int helperUpdate(Node node, int index, int value) {
        if (index >= node.startInterval && index <= node.endInterval) {
            if (index == node.startInterval && index == node.endInterval) {
                node.data = value;
                return node.data;
            }
            node.data = this.helperUpdate(node.left, index, value) + this.helperUpdate(node.right, index, value);
        }
        return node.data;
    }

    void display() {
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
            System.out.println("|---->" + node.data);
        } else {
            System.out.println(node.data);
        }
        prettyDisplay(node.left, level + 1);
    }

    // -------------------------------------------------------------------------------------
    // Main method to run the program
    public static void main(String[] args) {
        int[] nums = { 3, 8, 7, 6, -2, -8, 4, 9 };
        SegmentTree segmentTree = new SegmentTree(nums);
        segmentTree.display();

        System.out.println(segmentTree.query(2, 6) + "\n\n\n\n");

        segmentTree.update(0, 10);

        segmentTree.display();
        System.out.println(segmentTree.query(1, 1) + "\n\n\n\n");
    }
}
