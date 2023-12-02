package Random;

class NewThreadForWaitAndNotify implements Runnable {

    String threadName;
    boolean suspendFlag;
    Thread t;

    NewThreadForWaitAndNotify(String name) {
        threadName = name;
        t = new Thread(this, threadName);
        suspendFlag = false;
    }

    public void run() {
        try {
            for (int i = 0; i < 15; i++) {
                System.out.println(threadName + " : " + i);
                Thread.sleep(200);
                synchronized (this) {
                    while (suspendFlag) {
                        wait();
                        System.out.println("Thread " + threadName + " is waiting");
                    }
                }
            }
            System.out.println(threadName + " exiting.");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    synchronized void suspendThread() {
        suspendFlag = true;
        System.out.println("Called suspendThread() by " + threadName);
    }

    synchronized void resumeThread() {
        suspendFlag = false;
        System.out.println("Called resumeThread() by " + threadName);
        notify();
    }
}

public class WaitAndNotify {

    public static void main(String[] args) {

        NewThreadForWaitAndNotify threadObj1 = new NewThreadForWaitAndNotify("One");
        NewThreadForWaitAndNotify threadObj2 = new NewThreadForWaitAndNotify("Two");

        threadObj1.t.start();
        threadObj2.t.start();

        try {

            Thread.sleep(1000);
            threadObj1.suspendThread();
            System.out.println("Suspending one ");

            Thread.sleep(1000);
            threadObj1.resumeThread();
            System.out.println("Resuming one ");

            Thread.sleep(1000);
            threadObj2.suspendThread();
            System.out.println("Suspending two ");

            Thread.sleep(1000);
            threadObj2.resumeThread();
            System.out.println("Resuming two");

        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            System.out.println("Waiting for threads to finish");
            threadObj1.t.join();
            threadObj2.t.join();
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("Both threads joined. Exiting main thread.... Bubye");
    }
}