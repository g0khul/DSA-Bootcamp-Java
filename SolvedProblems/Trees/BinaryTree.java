package SolvedProblems.Trees;

import java.util.Scanner;

public class BinaryTree {
    Node root;

    public Node populate(Scanner scanner) {
        System.out.println("Enter the root node value : ");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner, root);
        return root;
    }

    private void populate(Scanner scanner, Node node) {
        System.out.println("Do you want to add value in the left of : " + node.value);
        boolean left = scanner.nextBoolean();

        if (left) {
            System.out.println("Enter the left value for : " + node.value);
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner, node.left);
        }

        System.out.println("Do you want to add value in the right of : " + node.value);
        boolean right = scanner.nextBoolean();

        if (right) {
            System.out.println("Enter the right value for : " + node.value);
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner, node.right);
        }

    }

    public void display() {
        display(root, "");
    }

    private void display(Node node, String indent) {
        if (node == null) {
            return;
        }
        System.out.println(indent + node.value);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
    }

    public void prettyDisplay() {
        display(root, 0);
    }

    private void display(Node node, int level) {
        if (node == null) {
            return;
        }
        display(node.right, level + 1);
        if (level != 0) {
            for (int i = 0; i < level; i++) {
                System.out.print("|\t");
            }
            System.out.println("|---->" + node.value);
        } else {
            System.out.println(node.value);
        }
        display(node.left, level + 1);

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
