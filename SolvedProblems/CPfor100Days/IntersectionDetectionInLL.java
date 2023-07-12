// https://leetcode.com/problems/intersection-of-two-linked-lists/
package SolvedProblems.CPfor100Days;

public class IntersectionDetectionInLL {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tailA = headA;
        int lengthA = 0;
        ListNode tailB = headB;
        int lengthB = 0;

        // Finding tail of the two lists
        while (tailA.next != null || tailB.next != null) {
            if (tailA.next != null) {
                tailA = tailA.next;
                lengthA++;
            }

            if (tailB.next != null) {
                tailB = tailB.next;
                lengthB++;
            }
        }

        if (tailA != tailB) {
            // No intersections would have occured
            return new ListNode(0);
        }

        // Moving the longest list with difference of lengths between the both list so
        // that the length after them becomes equal
        if (lengthA > lengthB) {
            int movement = lengthA - lengthB;
            for (int i = 0; i < movement; i++) {
                headA = headA.next;
            }
        }

        if (lengthB > lengthA) {
            int movement = lengthB - lengthA;
            for (int i = 0; i < movement; i++) {
                headB = headB.next;
            }
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
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
        ListNode listA = new ListNode(1);
        ListNode listB = new ListNode(20);
        listB.next = new ListNode(30);
        listB.next.next = new ListNode(40);
        
        ListNode link = new ListNode(10);
        ListNode temp = link;

        for (int i = 2; i < 6; i++) {
            temp.next = new ListNode(i * i);
            temp = temp.next;
        }

        listA.next = link;
        listB.next.next.next = link;

        display(listA);
        display(listB);
        System.out.println(getIntersectionNode(listA, listB).val);

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}