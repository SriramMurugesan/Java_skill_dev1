class BookingSeat extends Thread{
    @Override
    public void run() {
        System.out.println("seat no1 is booked");
        
    }
}
class Task1 extends Thread{
    @Override
    public void run() {
        for(int i = 1; i <= 5; i++) {
            System.out.println("task1 is running - " + i);
        }
    }
}
class Task2 extends Thread{
    @Override
    public void run() {
        for(int i = 1; i <= 5; i++) {
            System.out.println("task2 is running - " + i);
        }
    }
}

public class ThreadingDemo {
    public static void main(String[] args) {
        Task1 task1 = new Task1();
        Task2 task2 = new Task2();
        BookingSeat bookingSeat = new BookingSeat();

        task1.start();
        task2.start();
        bookingSeat.start();
    }   
}
