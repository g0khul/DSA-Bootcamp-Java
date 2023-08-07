// package SolvedProblem.CPfor100Days;

public class RotateLL {
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        
        int length = 1;
        ListNode tail = head;
        while(tail.next != null){
            tail = tail.next;
            length++;
        }

        k = k % length;

        if(k == 0){
            return head;
        }

        tail.next = head;
        ListNode newTemp = head;
        for(int i = 0; i < length - k - 1; i++){
            newTemp = newTemp.next;
        }
        ListNode temp = newTemp.next;
        newTemp.next = null;
        
        return temp;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(3);
        head = rotateRight(head, 2);
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
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}