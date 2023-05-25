package SolvedProblems.LinkedList.Problems;

public class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode sortList(ListNode head) {
        // return mergeSort(head);
        return bubbleSort(head);
    }

    // Bubble Sort
    private ListNode bubbleSort(ListNode head) {
        int size = getSize(head);
        ListNode node = head;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i; j++) {
                ListNode previous = node;
                node = node.next;
                if (previous.val > node.val) {
                    ListNode temp = new ListNode(node.val);
                    node.val = previous.val;
                    previous.val = temp.val;
                }
                node = node.next;
            }
            node = head;
        }

        return head;
    }

    private int getSize(ListNode head) {
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }

    // Merge Sort
    // private ListNode mergeSort(ListNode head) {
    //     if (head == null || head.next == null) {
    //         return head;
    //     }
    //     ListNode mid = middle(head);
    //     ListNode left = mergeSort(head);
    //     ListNode right = mergeSort(mid);
    //     return merge(left, right);
    // }

    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode result = new ListNode();
        ListNode tail = result;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        if (list1 != null) {
            tail.next = list1;
        }
        if (list2 != null) {
            tail.next = list2;
        }
        return result.next;
    }

    public ListNode middle(ListNode head) {
        ListNode full = head;
        ListNode half = null;

        while (full != null && full.next != null) {
            full = full.next.next;
            half = (half == null) ? head : half.next;
        }
        ListNode mid = half.next;
        half.next = null;
        return mid;
    }

    // public void reverse(ListNode node) {
    // if (node == tail) {
    // head = tail;
    // return;
    // }

    // reverse(node.next);

    // tail.next = node;
    // tail = node;
    // tail.next = null;

    // return;
    // }

    // Inpace reversal
    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode present = head;
        ListNode after = head.next;

        while (present != null) {
            present.next = previous;
            previous = present;
            present = after;
            if (after != null) {
                after = after.next;
            }
        }
        return previous;
    }

    // Reverse Inbetween
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if ((head == null || head.next == null) || (right - left == 0)) {
            return head;
        }
        ListNode previous = null;
        ListNode current = head;

        for (int i = 0; current != null && i < left - 1; i++) {
            previous = current;
            current = current.next;
        }

        ListNode firstPart = previous;
        ListNode reverseEnd = current;
        previous = null;

        ListNode after = current.next;
        for (int i = 0; current != null && i < right - left + 1; i++) {
            current.next = previous;
            previous = current;
            current = after;
            if (after != null) {
                after = after.next;
            }
        }
        if (firstPart != null) {
            firstPart.next = previous;
        } else {
            head = previous;
        }

        reverseEnd.next = current;
        return head;
    }

    // Palindrome in linkedlist
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode mid = getMid(head);
        ListNode reverse = reverse(mid);

        while (head != null && reverse != null) {
            if (head.val != reverse.val) {
                return false;
            }
            head = head.next;
            reverse = reverse.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode previous = null;
        ListNode present = head;
        ListNode after = head.next;

        while (present != null) {
            present.next = previous;
            previous = present;
            present = after;
            if (after != null) {
                after = after.next;
            }
        }
        return previous;
    }

    public ListNode getMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode full = head;
        ListNode half = head;
        while (full != null && full.next != null) {
            full = full.next.next;
            half = half.next;
        }
        return half;
    }

    // Reorder list
    public void reorderList(ListNode head) {
        ListNode mid = getMid(head);
        ListNode reverse = reverse(mid);

        ListNode answer = new ListNode();
        answer = head;
        answer.next = reverse.next;
        answer = answer.next.next;
        while (head != null && reverse != null) {
            answer = head.next;
            answer.next = reverse.next;
            answer = answer.next.next;
            head = head.next;
            reverse = reverse.next;
        }
        answer.next = (reverse != null) ? reverse : null;
        head = answer;
    }

    // 25. Reverse Nodes in k-Group
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }

        ListNode node = head;

        while (node != null && node.next != null) {
            ListNode tail = getTail(node, k);
            if (head == tail) {
                return head;
            }
            reverse(head, node, tail);
        }

        return head;
    }

    private ListNode getTail(ListNode head, int k) {
        ListNode tail = head;
        for (int i = 1; i < k; i++) {
            if (tail.next == null) {
                return head;
            }
            tail = tail.next;
        }
        return tail;
    }

    private ListNode reverse(ListNode head, ListNode start, ListNode end) {
        ListNode firstPart = head;
        while (firstPart != start) {
            firstPart = firstPart.next;
        }

        ListNode previous = null;
        ListNode present = start;
        ListNode after = start.next;

        ListNode presentTemp = present;
        while (present != end.next) {
            present.next = previous;
            previous = present;
            present = after;
            if (after != end.next && after.next != null) {
                after = after.next;
            }
        }
        firstPart.next = previous;
        presentTemp.next = (end.next != null) ? end.next : null;
        return previous;
    }
}
