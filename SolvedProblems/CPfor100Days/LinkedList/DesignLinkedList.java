package LinkedList;

public class DesignLinkedList {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        // list.addAtHead(10);
        // list.addAtHead(20);
        // list.addAtHead(30);
        // list.addAtHead(40);

        // list.addAtHead(10);
        // list.addAtTail(20);
        // list.addAtTail(30);
        // list.addAtHead(40);

        list.addAtIndex(0, 10);
        list.addAtIndex(1, 20);
        list.addAtIndex(2, 30);
        list.addAtIndex(3, 40);
        list.addAtIndex(4, 50);

        list.deleteAtIndex(4);

        System.out.println(list.tail.data);
        // list.deleteAtIndex(3);
        // System.out.println(list.get(3));

        list.display();
    }
}

class MyLinkedList {
    Node head;
    Node tail;
    int size;

    public class Node {
        int data;
        Node next;

        Node() {
        }

        Node(int data) {
            this.data = data;
        }
    }

    public MyLinkedList() {
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    public void addAtHead(int val) {
        if (head == null) {
            head = new Node(val);
            tail = head;
            size++;
            return;
        }

        Node temp = new Node(val);
        temp.next = head;
        head = temp;
        size++;
    }

    public void addAtTail(int val) {
        if (head == null) {
            addAtHead(val);
            return;
        }

        tail.next = new Node(val);
        tail = tail.next;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }

        if (index == 0) {
            addAtHead(val);
            return;
        }

        if (index == size) {
            addAtTail(val);
            return;
        }

        Node temp = head;
        Node previous = null;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
            if (previous == null) {
                previous = head;
            } else {
                previous = previous.next;
            }
        }

        Node newData = new Node(val);
        previous.next = newData;
        previous.next.next = temp;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index >= size) {
            return;
        }

        if (index == 0) {
            head = head.next;
            size--;
            return;
        }

        if(index == size - 1){
            Node temp = head;
            while(temp.next != tail){
                temp = temp.next;
            }
            tail = temp;
            tail.next = null;
            size--;
            return;
        }

        int i = 1;
        Node temp = head;
        while (i < index) {
            temp = temp.next;
            i++;
        }

        temp.next = temp.next.next;
        size--;
    }

    public void display() {
        if (head == null) {
            System.out.println("Nothing to display");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
