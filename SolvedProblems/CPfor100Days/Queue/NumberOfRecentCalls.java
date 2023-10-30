package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfRecentCalls {
    public static void main(String[] args) {

    }
}

class RecentCounter {
    private Queue<Integer> request;

    public RecentCounter() {
        request = new LinkedList<>();
    }

    public int ping(int t) {
        request.offer(t);

        while (t - request.peek() > 3000) {
            request.poll();
        }

        return request.size();
    }
}
