// import SolvedProblems.CPfor100Days;

public class SwappingNodesLL {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }

        if (k > count) {
            return head;
        }

        ListNode tempA = head;
        for(int i = 1; i < k; i++){
            tempA = tempA.next;
        }

        ListNode tempB = head;
        for (int i = 1; i <= count - k; i++) {
            tempB = tempB.next;
        }

        int value = tempA.val;
        tempA.val = tempB.val;
        tempB.val = value;

        return head;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.display(head);

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
            System.out.println(temp.val + " ");
            temp = temp.next;
        }
    }
}