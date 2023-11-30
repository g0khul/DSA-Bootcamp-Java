package CPfor100Days.LinkedList;

public class DeepCopyLL {
    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node oldTemp = head;
        Node newHead = new Node(head.val);
        Node newTemp = newHead;

        if (oldTemp.next != null) {
            newTemp.next = new Node(oldTemp.next.val);
        }

        while (oldTemp != null) {
            if (oldTemp.next != null) {
                newTemp.next = new Node(oldTemp.next.val);
            }
            oldTemp = oldTemp.next;
            newTemp = newTemp.next;
        }

        oldTemp = head;
        newTemp = newHead;

        while (oldTemp != null) {
            if (oldTemp.random != null) {
                assignRandom(oldTemp, newTemp, newHead, head);
            }
            oldTemp = oldTemp.next;
            newTemp = newTemp.next;
        }

        return newHead;
    }

    public static void assignRandom(Node oldTemp, Node newTemp, Node newHead, Node oldHead) {
        Node oldRandom = oldTemp.random;
        int count = 0;
        Node oldItr = oldHead;
        while (oldItr != oldRandom) {
            count++;
            oldItr = oldItr.next;
        }

        Node newItr = newHead;
        while (count != 0) {
            newItr = newItr.next;
            count--;
        }
        newTemp.random = newItr;
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp = head;
        for (int i = 1; i < 6; i++) {
            if (i % 2 == 0) {
                temp.random = head.next;
                System.out.println("I'm assigning random");
            } else {
                temp.random = head;
            }
            temp.next = new Node(i);
            temp = temp.next;
        }
        Node newone = copyRandomList(head);

        newone.display(head);
        System.out.println("----------------------Displaying random values-------------------");
        temp = newone;
        while (temp != null) {
            if (temp.random != null)
                System.out.print(temp.random.val + " ");
            temp = temp.next;
        }
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}