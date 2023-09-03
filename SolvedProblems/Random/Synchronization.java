package SolvedProblems.Random;

class Count {
    int count;

    /*
     * synchronized keyword is used to tell the threads that
     * this resource can only be provisioned to one thread at a time
     */
    public synchronized int increment() {
        return count++;
    }
}

public class Synchronization {
    public static void main(String[] args) throws Exception {
        Count c = new Count();
        // Refer RunnableThread.java if you don't understand what's going on below
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++)
                c.increment();
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++)
                c.increment();
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(c.count);
    }
}
