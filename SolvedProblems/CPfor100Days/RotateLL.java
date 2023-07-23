// package SolvedProblem.CPfor100Days;

public class RotateLL {
    public static ListNode rotateRight(ListNode head, int k) {
        while (k != 0) {
            ListNode tail = head;
            ListNode secondLast = null;
            while (tail.next != null) {
                if (tail == head) {
                    secondLast = head;
                } else {
                    secondLast = secondLast.next;
                }
                tail = tail.next;
            }

            secondLast = null;
            tail.next = head;
            head = tail;
            k--;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(3);
        head = rotateRight(head, 2);
        // head.display(head);
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    void display(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}