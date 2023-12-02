package StackQueue;

import java.util.*;

public class BinaryNosUptoN {
    public static void main(String[] args) {
        int n = 10;
        String result[] = new String[n];
        Queue<String> queue = new LinkedList<>();
        queue.offer("1");

        for (int i = 0; i < n; i++) {
            result[i] = queue.poll();
            String n1 = result[i] + "0";
            String n2 = result[i] + "1";
            queue.offer(n1);
            queue.offer(n2);

            System.out.print(result[i] + " ");
        }
        System.out.println();
    }
}
