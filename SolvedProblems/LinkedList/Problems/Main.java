package LinkedList.Problems;

public class Main {
    public static void main(String[] args) {
        // LinkedList list = new LinkedList();
    
        // for (int i = 0; i < 5; i++) {
        //     list.insert(i);
        // }

        // list.display();
        // list.insert(11, 03);
        // System.out.println();
        // list.display();
        // list.insert(1);
        // list.insert(1);
        // list.insert(1);
        // list.insert(2);
        // list.insert(2);
        // list.insert(3);
        // list.insert(4);

        // list.display();
        // System.out.println();
        // list.deleteDuplicates(list.head);
        // list.display();

        LinkedList list1 = new LinkedList();
        list1.insert(1);
        list1.insert(1);
        list1.insert(2);
        list1.insert(3);
        LinkedList list2 = new LinkedList();
        list2.insert(3);
        list2.insert(4);
        list2.insert(6);
        list2.insert(7);
        LinkedList result = new LinkedList();
        result = result.mergeTwoList(list1, list2);
        result.display();
        
    }
}
