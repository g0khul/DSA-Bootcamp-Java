package LinkedList;

public class AddTwoNumbersII {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String val1 = "";
        String val2 = "";

        ListNode temp = l1;
        while (temp != null) {
            val1 += temp.val;
            temp = temp.next;
        }

        temp = l2;
        while (temp != null) {
            val2 += temp.val;
            temp = temp.next;
        }

        int num1 = Integer.parseInt(val1);
        int num2 = Integer.parseInt(val2);
        int res = num1 + num2;

        ListNode result = null;
        while (res != 0) {
            ListNode New = new ListNode();
            New.val = res % 10;

            New.next = result;
            result = New;

            res = res / 10;
        }

        if (result == null) {
            return new ListNode(0);
        }

        return result;
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