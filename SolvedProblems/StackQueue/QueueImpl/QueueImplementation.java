package Queue;

class Queue {
    int queue[];
    int capacity;
    int front;
    int rear;
    int size;

    Queue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
    }

    public void enQueue(int data) {
        if (!isFull()) {
            queue[rear] = data;
            rear = (rear + 1) % capacity;
            size = size + 1;
        } else {
            System.out.println("Queue is full");
        }
    }

    public int deQueue() {

        int data = queue[front];
        if (!isEmpty()) {
            front = (front + 1) % capacity;
            size = size - 1;
        }
        return data;
    }

    public int getSize() {
        return size;
    }

    public boolean isFull() {
        return getSize() == capacity;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public void show() {
        System.out.print("Elements : ");
        for (int i = 0; i < getSize(); i++) {
            System.out.print(queue[(front + i) % capacity] + " ");
        }
        System.out.println();
    }

}

public class QueueImplementation {
    public static void main(String[] args) {
        Queue obj = new Queue(5);

        obj.enQueue(5);
        obj.enQueue(6);
        obj.enQueue(7);
        obj.enQueue(8);
        obj.enQueue(9);

        System.out.println("Size of the queue :" + obj.getSize());

        obj.deQueue();

        obj.show();

        System.out.println("Size of the queue :" + obj.getSize());

        obj.enQueue(29);
        obj.show();
        obj.enQueue(19);
        obj.show();
    }
}
