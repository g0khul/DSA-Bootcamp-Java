package SolvedProblems.Trees.BinarySearchTree;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BinarySearchTree tree = new BinarySearchTree();
        for (int i = 0; i < 6; i++) {
            int value = scanner.nextInt();
            tree.insert(value);
        }
        tree.display();
        // System.out.println(tree.isEmpty());
        System.out.println("\n\n");
        tree.postOrder();

        scanner.close();
    }
}
