package LinkedList.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        
        for (int i = 1; i < 5; i++) {
            list.insert(i);
        }

        list.insert(1, 0);
        // list.deleteAtFirst();
        // list.deleteAtLast();
        list.deleteAtIndex(2);
        
        list.display();

        System.out.println();
        System.out.println(list.size);

    }
}
