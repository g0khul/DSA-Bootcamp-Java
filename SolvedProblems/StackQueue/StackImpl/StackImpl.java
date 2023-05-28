// Implementing stack using linked list
class StackLinkedList {
    int data;
    StackLinkedList next;
}

public class StackImpl {

    StackLinkedList head;

    public void push(int data) {
        StackLinkedList node = new StackLinkedList();
        node.data = data;
        node.next = null;

        if (head == null) {
            head = node;
            System.out.println("New stack is created");
        } else {
            StackLinkedList n = head;

            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
        }

    }

    public void pop() {

        if (head == null) {
            System.out.println("Nothing to pop");
        } else {
            StackLinkedList n = head;
            int size = sizeOf();
            for (int i = 1; i < size - 1; i++) {
                n = n.next;
            }
            n.next = null;
        }
    }

    public void peek() {

        StackLinkedList n = head;
        while (n.next != null) {
            n = n.next;
        }
        System.out.println(n.data + " is at peek");
    }

    public boolean isEmpty() {

        if (head == null)
            return true;
        else
            return false;
    }

    public int sizeOf() {

        int size = 0;
        if (head == null) {
            return size;
        } else {
            StackLinkedList n = head;
            while (n.next != null) {
                n = n.next;
                size++;
            }
        }
        return size + 1;
    }

    public void display() {
        StackLinkedList n = head;
        while (n.next != null) {
            System.out.println(n.data);
            n = n.next;
        }
        System.out.println(n.data);
    }
}
