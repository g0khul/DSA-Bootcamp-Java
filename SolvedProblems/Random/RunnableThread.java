package SolvedProblems.Random;

// Runnable using lambda expression

public class RunnableThread {
    public static void main(String[] args) throws Exception {

        /*
         * We're using lambda expression because the only purpose of Hi and
         * Hello class in that Multithread.java class is to call the run method
         * which is the only method in the Runnable interface.
         * 
         * And because Runnable is a functional interface we can simply use
         * lambda expression instead of two classes because we only need those
         * classes once.
         * 
         */

        /*
         * Anyway we're going to pass the object in the thread constructor
         * So why create another object for that?
         * 
         * That why I've passsed the lambda expression directly into the
         * thread constructor
         */

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Hi");
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                }
            }
        }, "Hi thread");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Hello");
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                }
            }
        }, "Hello thread");

        /*
         * This start method can only call run so by default we have to
         * override run method
         */
        t1.start();

        /*
         * Adding a delay of 10ms because schedular calls run methods from
         * both classes at random order
         */
        try {
            Thread.sleep(10);
        } catch (Exception e) {
        }

        t2.start();

        /*
         * isAlive() is a method to check if the thread is alive or not
         */

        System.out.println((t1.isAlive()) ? "Thread 1 is alive" : "Thread 1 is not alive");

        /*
         * If I want to print something after the execution of both the threads
         * then we have to use the the method join() which makes the main thread
         * to wait till the other thread joins the main thread.
         * 
         * This join may throw a exception so we have to handle those exception.
         */

        t1.join();
        t2.join();

        System.out.println("Executing this statement after the "
                + "threads joining the main thread");

    }
}