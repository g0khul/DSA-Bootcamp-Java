package LinkedList.CircularLinkedList;

public class Main {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        for (int i = 0; i < 5; i++) {
            list.insertAtFirst(i);
        }
        list.display();
        // list.insert(10);
        // System.out.println();
        // list.display();

        System.out.println();
        list.delete();
        list.display();


        System.out.println();
        System.out.println(list.size);
    }
}
