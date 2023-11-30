package CPfor100Days.LinkedList;

import java.util.Stack;

public class PartitionList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);

        head.next = new ListNode(1);
        // head.next.next = new ListNode(3);
        // head.next.next.next = new ListNode(2);
        // head.next.next.next.next = new ListNode(5);
        // head.next.next.next.next.next = new ListNode(2);

        int x = 0;
        head = partitions(head, x);
        display(head);

    }

    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        // Find greatest
        ListNode temp = head;
        ListNode max = head;

        while (temp.val != x) {
            if (temp.val > max.val) {
                max = temp;
                break;
            }
            temp = temp.next;
        }

        ListNode marker = new ListNode();
        ListNode result = marker;
        marker.next = head;
        while (marker.next != max) {
            marker = marker.next;
        }

        // Find lesser values and put it after temp
        ListNode prevFinder = temp;
        ListNode finder = temp.next;
        while (finder != null) {
            if (finder.val < x) {
                ListNode node = finder.next;
                marker.next = finder;
                marker = marker.next;

                finder = node;
                marker.next = max;
                prevFinder.next = finder;
            } else {
                prevFinder = finder;
                finder = finder.next;
            }
        }

        return result.next;
    }

    public static void display(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static ListNode partitions(ListNode head, int x) {
        Stack<ListNode> stack = new Stack<>();

        ListNode temp = head;
        ListNode prev = null;
        while (temp != null) {
            if (temp.val < x) {
                stack.push(temp);
                temp = temp.next;
                if (prev != null) {
                    prev.next = temp;
                } else {
                    head = temp;
                }
            } else {
                prev = temp;
                temp = temp.next;
            }
        }

        if(stack.isEmpty()){
            return head;
        }

        ListNode result = new ListNode();
        while (!stack.isEmpty()) {
            result.next = stack.pop();
            result.next.next = head;
            head = result.next;
        }

        return result.next;
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

    public void add(int value) {
        ListNode newNode = new ListNode(value);
        if (this.next == null) {
            this.next = newNode;
        } else {
            ListNode current = this;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
}