package SolvedProblems.LinkedList.DoublyLinkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        for (int i = 5; i > 0; i--) {
            list.insertAtFirst(i);
        }

        list.insert(10);
        list.display();
        list.delete(2);
        System.out.println();
        list.display();

        // System.out.println();
        // list.displayReverse();
        
        System.out.println();
        System.out.println(list.size);
    }
}
