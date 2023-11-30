package CPfor100Days.LinkedList;

import java.math.BigInteger;

public class AddTwoNumbersII {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();

        ListNode temp = l1;
        while(temp != null){
            num1.append(temp.val);
            temp = temp.next;
        }

        temp = l2;
        while(temp != null){
            num2.append(temp.val);
            temp = temp.next;
        }

        BigInteger n1 = new BigInteger(num1.toString());
        BigInteger n2 = new BigInteger(num2.toString());

        n1 = n1.add(n2);
        ListNode result = new ListNode(n1.remainder(BigInteger.TEN).intValue());
        n1 = n1.divide(BigInteger.TEN);         

        while(!n1.equals(BigInteger.ZERO)){
            temp = new ListNode(n1.remainder(BigInteger.TEN).intValue());
            temp.next = result;
            result = temp; 
            n1 = n1.divide(BigInteger.TEN);         
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode num1 = new ListNode(7);
        num1.next = new ListNode(2);
        num1.next.next = new ListNode(4);
        num1.next.next.next = new ListNode(3);

        ListNode num2 = new ListNode(5);
        num2.next = new ListNode(6);
        num2.next.next = new ListNode(4);

        ListNode result = addTwoNumbers(num1, num2);
        ListNode temp = result;
        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
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