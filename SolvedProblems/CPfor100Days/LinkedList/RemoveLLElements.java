package LinkedList;

public class RemoveLLElements {
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode temp = head;

        while (temp.next != null) {
            if (temp.val == val && temp == head) {
                head = head.next;
                temp = head;
            } else if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }

        if (head.val == val) {
            return null;
        }

        return head;
    }

    public static void display(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        ListNode temp = head;

        for (int i = 1; i < 6; i++) {
            temp.next = new ListNode(i * i);
            temp = temp.next;
        }

        temp.next = new ListNode(10);
        head = removeElements(head, 10);
        display(head);
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
}
