package CPfor100Days.LinkedList;

// https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/description/
// package SolvedProblems.CPfor100Days;

import java.util.ArrayList;

public class BinaryNoToIntInLL {
    public static int getDecimalValue(ListNode head) {
        if(head == null){
            return 0;
        }

        ArrayList<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while(temp != null){
            list.add(temp.val);
            temp = temp.next;
        }

        int result = 0;
        for(int i = list.size() - 1, multiple = 1; i >= 0; i--, multiple *= 2){
            result += list.get(i) * multiple;
        }

        return result;
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
