// Topic: Thread Introduction & Thread Creation

// Way 1: Creating a thread by extending the Thread class
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("1. Thread running using 'extends Thread'");
    }
}

// Way 2: Creating a thread by implementing the Runnable interface
class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("2. Thread running using 'implements Runnable'");
    }
}

public class ThreadCreationDemo {
    public static void main(String[] args) {
        System.out.println("Main thread name: " + Thread.currentThread().getName());

        // 1. Using Thread class
        MyThread t1 = new MyThread();
        t1.start(); // start() creates a new thread and calls run()

        // 2. Using Runnable interface
        MyRunnable myRunnable = new MyRunnable();
        Thread t2 = new Thread(myRunnable);
        t2.start();

        // 3. Modern Lambda way (short way of Runnable)
        Thread t3 = new Thread(() -> {
            System.out.println("3. Thread running using Lambda expression");
        });
        t3.start();
    }
}
