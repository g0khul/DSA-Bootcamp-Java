//Extending the class Thread

class Hi extends Thread {

    // Overriding run method in Thread class
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hi");
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

// Extending the class Thread
class Hello extends Thread {

    // Overriding run method in Thread class
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello");
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

public class MultiThread {
    public static void main(String[] args) {
        // Using Thread class
        Hi obj1 = new Hi();
        Hello obj2 = new Hello();

        // This start method can only call run so by default we have to override run
        // method
        obj1.start();

        // Adding a delay of 10ms because schedular calls run methods from both classes
        // at random order
        try {
            Thread.sleep(10);
        } catch (Exception e) {
            System.out.println(e);
        }

        obj2.start();

    }
}
