package CPfor100Days.Stack;

public class DesignAStackWithIncrementOperation {
    public static void main(String[] args) {
        CustomStack stack = new CustomStack(10);

        // for (int i = 1; i < 11; i++) {
        //     stack.push(i);
        // }

        // System.out.println(stack.pop());
        // stack.display();
        // stack.increment(12, 1);
        // stack.display();
        System.out.println(stack.pop());

    }
}

class CustomStack {
    class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node prev) {
            this.data = data;
            this.prev = prev;
        }
    }

    int maxSize;
    int size;
    Node head;
    Node tail;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        size = 0;
    }

    public void push(int x) {
        if (size == 0) {
            head = new Node(x);
            tail = head;
        } else if (size <= maxSize) {
            tail.next = new Node(x, tail);
            tail = tail.next;
        } else {
            return;
        }
        size++;
    }

    public int pop() {
        if (head == null) {
            return -1;
        }

        if(tail == head){
            Node temp = head;
            head = null;
            tail = null;
            size--;
            return temp.data;
        }

        Node temp = tail;
        tail = tail.prev;
        tail.next = null;
        size--;

        return temp.data;
    }

    public void increment(int k, int val) {
        int limit = (k < size) ? k : size;
        Node temp = head;
        while (limit-- != 0) {
            temp.data += val;
            temp = temp.next;
        }
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }
}
