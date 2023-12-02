package CPfor100Days.LinkedList;

public class InsertionSortInLL {
    public static ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode current = head.next;
        head.next = null;

        while(current != null){
            ListNode previous = dummy;
            while(previous != null && previous.next.val < current.val){
                previous = previous.next;
            }

            ListNode nextPart = current.next;
            current.next = previous.next;
            previous.next = current;
            current = nextPart;
        }

        return dummy.next;
    }

    public static void main(String[] args) {

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
