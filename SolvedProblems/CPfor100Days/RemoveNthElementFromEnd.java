public class RemoveNthElementFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return head;
        }

        ListNode temp = head;
        int length = 0;
        while(temp != null){
            temp = temp.next;
            length++;
        }

        System.out.println(length);

        if(length == n){
            head = head.next;
            return head;
        }

        temp = head;
        for (int i = 1; i < length - n; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for(int i = 2; i < 6; i++){
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        removeNthFromEnd(head, 2);

        temp = head;
        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}
