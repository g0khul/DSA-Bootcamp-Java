package Trees;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);
        tree.display();
        System.out.println("-----------------------------------------");
        tree.prettyDisplay();

        tree.display();
        // System.out.println(tree.isEmpty());
        System.out.println("\n\n");
        tree.postOrder();

        scanner.close();
    }
}
