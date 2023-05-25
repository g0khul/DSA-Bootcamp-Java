package SolvedProblems.LinkedList.Problems;

public class LinkedList {
    Node head;

    public void insert(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
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

    void insert(int data, int index) {
        insertRecursion(data, index - 1, head);
    }

    private Node insertRecursion(int data, int index, Node previous) {
        if (index == 0) {
            Node temp = previous.next;
            previous.next = new Node(data, temp);
            return previous;
        }

        Node temp = previous;
        return insertRecursion(data, index - 1, temp.next);
    }

    public void deleteDuplicates(Node head) {
        if (head == null) {
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            if (temp.data == temp.next.data) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
    }

    public LinkedList mergeTwoList(LinkedList list1, LinkedList list2) {
        if (list1.head == null) {
            return list2;
        }
        if (list2.head == null) {
            return list1;
        }

        Node f = list1.head;
        Node s = list2.head;
        LinkedList result = new LinkedList();
        while (f.next != null && s.next != null) {
            if (f.data <= s.data) {
                result.insert(f.data);
                f = f.next;
            } else {
                result.insert(s.data);
                s = s.next;
            }
        }
        while (f != null) {
            result.insert(f.data);
            f = f.next;
        }

        while (s != null) {
            result.insert(s.data);
            s = s.next;
        }
        return result;
    }

    // public boolean hasCycle(Node head) {
    // if (head == null || head.next == null) {
    // return false;
    // }

    // Node fast = head;
    // Node slow = head;

    // while (fast != null && fast.next != null) {
    // slow = slow.next;
    // fast = fast.next.next;
    // if (fast == slow) {
    // return true;
    // }
    // }
    // return false;
    // }

    public int hasCycle(Node head) {
        if (head == null || head.next == null) {
            return 0;
        }

        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                // Calculating length
                return cycleLength(fast, slow);
            }
        }
        return 0;
    }

    private int cycleLength(Node fast, Node slow) {
        int length = 0;
        do {
            slow = slow.next;
            length++;
        } while (fast != slow);
        return length;
    }

    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;

        do {
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        } while(fast != slow);

        if(slow == 1){
            return true;
        }
        return false;
    }

    public int findSquare(int n){
        int result = 0;
        while(n != 0){
            result += (n % 10) * (n % 10);
            n = n / 10;
        }
        return result;
    }

}
