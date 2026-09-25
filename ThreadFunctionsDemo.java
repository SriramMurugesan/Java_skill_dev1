// Topic: Multithreading & Thread Functions: sleep(), yield(), join()

class Worker extends Thread {
    public Worker(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(getName() + " working step " + i);
            try {
                // sleep(milliseconds): pauses this thread for 300 ms
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

            // yield(): hints to scheduler that this thread can give turn to other threads
            Thread.yield();
        }
    }
}

public class ThreadFunctionsDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("--- Starting Two Threads (Multithreading) ---");

        Worker t1 = new Worker("Worker-1");
        Worker t2 = new Worker("Worker-2");

        t1.start();
        t2.start();

        // join(): makes the current thread (main) wait until t1 and t2 finish
        System.out.println("Main thread is waiting for workers to finish using join()...");
        t1.join();
        t2.join();

        System.out.println("--- Both workers finished! Main thread continues and ends. ---");
    }
}
