// https://leetcode.com/problems/delete-node-in-a-linked-list/
package LinkedList;

public class DeleteNodeInLL {
    public static void display(ListNode head){
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    
    public static void deleteNode(ListNode node) {
        ListNode temp = node;
        // Do it for all the values
        while (temp.next != null) {
            temp.val = temp.next.val;
            temp = temp.next;
        }

        // For the last node
        while (node.next != temp) {
            node = node.next;
        }

        node.next = null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        ListNode temp = head;
        
        for(int i = 2; i < 6; i++) {
            temp.next = new ListNode(i * i);
            temp = temp.next;
        }

        display(head);
        deleteNode(head.next.next);
        display(head);        
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
