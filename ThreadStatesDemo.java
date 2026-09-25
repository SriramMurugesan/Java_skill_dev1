// Topic: States of Threads (Thread Life Cycle)
// Common States: NEW -> RUNNABLE -> TIMED_WAITING -> TERMINATED

public class ThreadStatesDemo {
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            try {
                // Moving into TIMED_WAITING state
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        });

        // State 1: NEW (Thread is created, but start() is not yet called)
        System.out.println("State 1 (before start): " + thread.getState());

        // State 2: RUNNABLE (start() has been called, thread is ready/running)
        thread.start();
        System.out.println("State 2 (after start):  " + thread.getState());

        // Wait 100ms so the child thread enters Thread.sleep()
        Thread.sleep(100);

        // State 3: TIMED_WAITING (Thread is paused using sleep)
        System.out.println("State 3 (during sleep): " + thread.getState());

        // Wait for the thread to completely finish
        thread.join();

        // State 4: TERMINATED (Thread execution is complete)
        System.out.println("State 4 (after finish): " + thread.getState());
    }
}
