class MainClass {
    int num;
    boolean flag = false;

    public synchronized void setNum(int num) {

        // Checking if Consumer has done its work if yes then go ahead and notify or
        // else wait

        while (flag) {
            try {
                wait();
            } catch (Exception e) {
            }
        }

        System.out.println("Set : " + num);
        this.num = num;
        flag = true;
        notify();
    }

    public synchronized void getNum() {

        // Checking if Producer has done its work if yes then go ahead and notify or
        // else wait

        while (!flag) {
            try {
                wait();
            } catch (Exception e) {
            }
        }

        System.out.println("Get : " + num);
        flag = false;
        notify();
    }
}

class Producer implements Runnable {

    MainClass ProducerObj;

    public Producer(MainClass ProducerObj) {
        this.ProducerObj = ProducerObj;
        Thread t1 = new Thread(this, "Producer Thread");
        t1.start();
    }

    public void run() {
        int i = 0;
        while (true) {
            ProducerObj.setNum(i++);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }
    }
}

class Consumer implements Runnable {

    MainClass ConsumerObj;

    public Consumer(MainClass ConsumerObj) {
        this.ConsumerObj = ConsumerObj;
        Thread t2 = new Thread(this, "Consumer");
        t2.start();
    }

    public void run() {
        while (true) {
            ConsumerObj.getNum();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }
}

public class InterThreadCommunication {
    public static void main(String[] args) {
        MainClass mainObj = new MainClass();
        // Anonymous objects
        new Producer(mainObj);
        new Consumer(mainObj);
    }
}