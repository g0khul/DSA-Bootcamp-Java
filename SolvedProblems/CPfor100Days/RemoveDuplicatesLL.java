public class RemoveDuplicatesLL {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = head;
        ListNode result = new ListNode();
        ListNode resultTemp = result;
        boolean flag = false;
        while (temp.next != null) {
            if (temp.val != temp.next.val) {
                if (!flag) {
                    resultTemp.next = new ListNode(temp.val);
                    resultTemp = resultTemp.next;
                } else {
                    flag = false;
                }

            } else {
                flag = true;
            }
            temp = temp.next;
        }

        if (!flag) {
            resultTemp.next = new ListNode(temp.val);
        }

        return result.next;
    }

    public static void display(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(3);
        head = deleteDuplicates(head);
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
