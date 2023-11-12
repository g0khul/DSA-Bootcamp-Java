package LinkedList.SinglyLinkedList;

public class LinkedList {
    Node head;
    Node tail;

    int size;

    public LinkedList() {
        this.size = 0;
    }

    public void insert(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            tail = head;
            size++;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
            tail = temp;
            size++;
        }
    }

    public void insert(int index, int data) {
        if (index == 0) {
            insertAtFirst(data);
            return;
        }
        if (index == size) {
            insertAtLast(data);
            return;
        }

        Node temp = head;
        int count = 1;
        while (count < index) {
            temp = temp.next;
            count++;
        }
        Node node = new Node(data, temp.next);
        temp.next = node;
        size++;
    }

    private void insertAtLast(int data) {
        if (head == null) {
            head = new Node(data);
            tail = head;
            size++;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(data);
        tail = temp.next;
    }

    private void insertAtFirst(int data) {
        if (head == null) {
            head.data = data;
            tail = head;
            size++;
        }
        Node temp = new Node(data);
        temp.next = head;
        head = temp;
        size++;
    }

    public void deleteAtFirst() {
        if (head == null) {
            System.out.println("Nothing to remove");
            return;
        }
        head = head.next;
        if (head.next == null) {
            tail = null;
        }
        size--;
    }

    public void deleteAtLast() {
        if (head == null) {
            System.out.println("Nothing to remove");
            return;
        }
        Node temp = head;
        for (int i = 0; i < size - 2; i++) {
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
        size--;
    }

    public void deleteAtIndex(int index) {
        if (head == null) {
            System.out.println("Nothing to remove");
            return;
        }
        if (index == 0) {
            deleteAtFirst();
            return;
        }
        if (index == size - 1) {
            deleteAtLast();
            return;
        }

        Node temp = head;
        int count = 1;
        while(count < index - 1){
            temp = temp.next;
            count++;
        }
        Node node = temp.next;
        temp.next = node.next;
        size--;
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
    }
}