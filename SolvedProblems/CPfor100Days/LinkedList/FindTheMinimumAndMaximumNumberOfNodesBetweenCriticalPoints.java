package CPfor100Days.LinkedList;

import java.util.ArrayList;
import java.util.Arrays;

public class FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints {
    public static void main(String[] args) {
        ListNode head = new ListNode(5);

        head.add(3);
        head.next.add(1);
        head.next.next.add(2);
        head.next.next.next.add(5);
        head.next.next.next.next.add(1);
        head.next.next.next.next.next.add(2);

        // ListNode head = new ListNode(2);
        // head.add(3);
        // head.next.add(3);
        // head.next.next.add(2);
        head.display(head);

        int[] result = nodesBetweenCriticalPoints(head);
        System.out.println(Arrays.toString(result));

    }

    public static int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[] { -1, -1 };
        }

        ArrayList<ListNode> criticalPoints = new ArrayList<>();
        ListNode iterator = head.next;
        ListNode previous = head;

        while (iterator.next != null) {
            if ((previous.val < iterator.val && iterator.val > iterator.next.val)
                    || (previous.val > iterator.val && iterator.val < iterator.next.val)) {
                criticalPoints.add(iterator);
            }

            previous = iterator;
            iterator = iterator.next;
        }

        if (criticalPoints.size() == 0) {
            return new int[] { -1, -1 };
        }

        int maxima = getDistance(criticalPoints.get(0), criticalPoints.get(criticalPoints.size() - 1));
        int minima = Integer.MAX_VALUE;
        for (int i = 0; i < criticalPoints.size() - 1; i++) {
            int distance = getDistance(criticalPoints.get(i), criticalPoints.get(i + 1));
            minima = (minima > distance) ? distance : minima;
        }

        maxima = (maxima == 0) ? -1 : maxima;
        minima = (minima == Integer.MAX_VALUE) ? -1 : minima;

        return new int[] { minima, maxima };
    }

    private static int getDistance(ListNode start, ListNode end) {
        int length = 0;

        while (start != end) {
            start = start.next;
            length++;
        }

        return length;
    }

    // public static int[] nodesBetweenCriticalPoints(ListNode head) {
    // if (head == null || head.next == null || head.next.next == null) {
    // return new int[] { -1, -1 };
    // }

    // ListNode iterator = head.next;
    // ListNode previous = head;
    // int minima = Integer.MAX_VALUE;
    // int maxima = Integer.MIN_VALUE;

    // while (iterator != null) {
    // if ((iterator.next != null)
    // && ((previous.val < iterator.val && iterator.val > iterator.next.val)
    // || (previous.val > iterator.val && iterator.val < iterator.next.val))) {

    // ListNode finder = iterator.next;
    // ListNode previousFinder = iterator;
    // int distance = 1;

    // while (finder.next != null) {
    // if ((previousFinder.val < finder.val && finder.val > finder.next.val)
    // || (previousFinder.val > finder.val && finder.val < finder.next.val)) {
    // minima = (minima > distance) ? distance : minima;
    // maxima = (maxima < distance) ? distance : maxima;
    // }

    // previousFinder = finder;
    // finder = finder.next;
    // distance++;
    // }
    // }

    // previous = iterator;
    // iterator = iterator.next;
    // }

    // minima = (minima == Integer.MAX_VALUE) ? -1 : minima;
    // maxima = (maxima == Integer.MIN_VALUE) ? -1 : maxima;

    // return new int[] { minima, maxima };
    // }
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

    void add(int value) {
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

    void display(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
