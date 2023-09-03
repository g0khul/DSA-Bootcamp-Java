package SolvedProblems.Random;

import java.util.*;

public class ReverseArrayList {

    static ArrayList<Integer> list = new ArrayList<>();

    public static void swap(ArrayList<Integer> list, int start, int end) {
        int temp = list.get(start);
        list.set(start, list.get(end));
        list.set(end, temp);

        /*
         * It can be easily done using Collections by using the below line
         * Collections.swap(list,start,end)
         */
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 9; i++)
            list.add(i);

        sc.close();
        System.out.println("The original list is: \n" + list.toString());

        for (int start = 0, end = list.size() - 1; start < end; start++, end--) {
            swap(list, start, end);
        }

        System.out.println("\nThe reversed list is\n" + list.toString());

    }
}
