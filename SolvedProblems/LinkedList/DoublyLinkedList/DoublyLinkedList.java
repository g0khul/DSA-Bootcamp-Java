package SolvedProblems.LinkedList.DoublyLinkedList;

public class DoublyLinkedList {
    Node head;
    Node tail;
    int size;

    DoublyLinkedList() {
        size = 0;
    }

    Node get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    void insertAtFirst(int data) {
        if (isEmpty()) {
            head = new Node(data);
            tail = head;
            size++;
            return;
        }
        Node temp = new Node(data);
        temp.next = head;
        head.previous = temp;
        head = temp;
        size++;
    }

    void insert(int data) {
        if (head == null) {
            insertAtFirst(data);
            return;
        }
        Node temp = get(size - 1);
        temp.next = new Node(data);
        Node node = temp.next;
        node.previous = temp;
        tail = node;
        size++;
    }

    void delete() {
        if (isEmpty()) {
            System.out.println("Nothing to delete");
            return;
        }
        tail = tail.previous;
        tail.next = null;
        size--;
    }

    void delete(int index) {
        if(isEmpty()){
            System.out.println("Nothing to delete");
            return;
        }
        Node temp = get(index);
        Node node = temp.next;
        temp = temp.previous;
        temp.next = node;
        size--;
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Nothing to desplay");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
    }

    void displayReverse() {
        if (isEmpty()) {
            System.out.println("Nothing to display");
            return;
        }
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.previous;
        }
    }

    private boolean isEmpty() {
        return (head == null) ? true : false;
    }
}
