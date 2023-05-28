class Node {
    int data;
    Node next;
}

class LinkedList {

    Node head;

    public void insert(int data) {
        Node node = new Node();
        node.data = data;
        node.next = null;

        if (head == null) {
            head = node;
        } else {
            Node n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
        }
    }

    public void inserAtStart(int data) {
        Node node = new Node();
        node.data = data;
        node.next = head;
        head = node;
    }

    public void insertAt(int index, int data) {
        Node node = new Node();
        node.data = data;
        node.next = null;

        if (index == 0) {
            inserAtStart(data);
        } else {
            Node n = head;
            for (int i = 0; i < index - 1; i++) {
                n = n.next;
            }
            node.next = n.next;
            n.next = node;
        }
    }

    public void deleteAt(int index) {

        if (index == 0) {
            head = head.next;
        }

        else {
            Node n = head;
            for (int i = 0; i < index - 1; i++) {
                n = n.next;
            }
            Node tempN1 = n.next;
            n.next = tempN1.next;
            System.out.println("Deleting " + tempN1.data);
        }

    }

    public void show() {
        Node node = head;

        while (node.next != null) {
            System.out.println(node.data);
            node = node.next;
        }
        System.out.println(node.data);
    }

}

public class SinglyLinkedListImplementation {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(5);
        list.insert(6);
        list.insert(7);

        list.inserAtStart(8);
        list.insertAt(0, 12);
        list.deleteAt(3);

        list.show();
    }
}
