package Trees.Problems;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void display(Node root) {
        if (root == null) {
            return;
        }

        helperDisplay(root, new LinkedList<Node>());
    }

    private static void helperDisplay(Node node, Queue<Node> queue) {
        // Add left child to the queue
        if (node.left != null) {
            queue.offer(node.left);
        }

        // Add right child to the queue
        if (node.right != null) {
            queue.offer(node.right);
        }

        System.out.print(node.value + " ");
        if (!queue.isEmpty()) {
            helperDisplay(queue.poll(), queue);
        }
    }

    public static void leftView(Node root){
        if(root == null){
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            Node currentNode = queue.poll();
            System.out.print(currentNode.value + " ");

            if(currentNode.left != null){
                queue.offer(currentNode.left);
            }

            if(currentNode.right != null){
                queue.offer(currentNode.right);
            }
        }

        System.out.println();

    }

    
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.populate(15);
        tree.populate(7);
        tree.populate(30);
        tree.populate(4);
        tree.populate(11);
        tree.populate(20);
        tree.populate(35);
        tree.populate(2);
        tree.populate(5);
        tree.populate(17);
        tree.populate(25);
        // display(tree.root);
        // System.out.println();
        tree.display();

        BFS.leftView(tree.root);
    }
}
