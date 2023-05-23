package SolvedProblems.LinkedList.DoublyLinkedList;

public class Node {
    Node previous;
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }

    public Node(Node previous, int data, Node next) {
        this.previous = previous;
        this.data = data;
        this.next = next;
    }
}
