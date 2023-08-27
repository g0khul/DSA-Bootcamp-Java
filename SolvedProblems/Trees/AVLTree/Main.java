package SolvedProblems.Trees.AVLTree;

public class Main {
    public static void main(String[] args) {
        AVL tree = new AVL();

        for (int i = 1; i <= 100; i++) {
            tree.insert(i);
        }

        tree.display();
    }
}
