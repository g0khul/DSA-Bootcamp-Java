package StackQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {
    public static void main(String[] args) {
        char[] tasks = { 'A', 'A', 'A', 'B', 'B', 'B' };
        int n = 2;
        System.out.println(leastInterval(tasks, n));
    }

    public static int leastInterval(char[] tasks, int n) {
        int[] frequency = new int[26];
        for (char c : tasks) {
            frequency[c - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] != 0) {
                maxHeap.add(frequency[i] * -1);
            }
        }

        Queue<List<Integer>> queue = new LinkedList<>();
        int time = 0;

        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
            time++;
            if (!maxHeap.isEmpty()) {
                int t = 1 + maxHeap.poll();
                if (t < 0) {
                    queue.offer(new ArrayList<>(Arrays.asList(t, time + n)));
                }
            }

            if (!queue.isEmpty() && queue.peek().get(1) == time) {
                maxHeap.add(queue.poll().get(0));
            }
        }

        return time;
    }
}
