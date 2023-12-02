package StackQueue;

public class DesignCircularQueue {
    public static void main(String[] args) {
        MyCircularQueue queue = new MyCircularQueue(5);
        for (int i = 1; i < 6; i++) {
            queue.enQueue(i);
        }

        System.out.println(queue.Front());
        System.out.println(queue.Rear());

        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());

        System.out.println(queue.enQueue(11));
        System.out.println(queue.enQueue(12));
        System.out.println(queue.enQueue(13));
        System.out.println(queue.enQueue(14));

        System.out.println(queue.enQueue(21));
        System.out.println(queue.enQueue(22));
        System.out.println(queue.enQueue(23));
        System.out.println(queue.enQueue(24));

        queue.display();
    }
}

class MyCircularQueue {
    int[] queue;
    int start;
    int end;

    public MyCircularQueue(int k) {
        queue = new int[k];
        start = -1;
        end = -1;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        if (start == -1) {
            queue[++start] = value;
            end++;
            return true;
        }

        end = (end + 1) % queue.length;
        queue[end] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        if (start == end) {
            start = -1;
            end = -1;
            return true;
        }

        start = (start + 1) % queue.length;

        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }

        return queue[start];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }

        return queue[end];
    }

    public boolean isEmpty() {
        return start == -1;
    }

    public boolean isFull() {
        if (start == (end + 1) % queue.length) {
            return true;
        }

        return false;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        for (int i = start; i != end; i = (i + 1) % queue.length) {
            System.out.print(queue[i] + " ");
        }
        System.out.print(queue[end]);
        System.out.println();
    }
}
