package LinkedList.CircularLinkedList;

public class CircularLinkedList {
    Node head;
    Node tail;
    int size;

    CircularLinkedList() {
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
        head = temp;
        tail.next = head;
        size++;
    }

    void insert(int data) {
        if (isEmpty()) {
            insertAtFirst(data);
            return;
        }
        Node temp = new Node(data, head);
        tail.next = temp;
        tail = temp;
        size++;
    }

    void delete(){
        if(isEmpty()){
            System.out.println("Nothing to delete");
            return;
        }
        Node temp = head;
        while(temp.next != tail){
            temp = temp.next;
        }
        tail = temp;
        tail.next = head;
        size--;
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Nothing to display");
            return;
        }
        Node temp = head;
        while (temp != tail) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print(temp.data + " -> ");
    }

    private boolean isEmpty() {
        return (head == null) ? true : false;
    }
}
