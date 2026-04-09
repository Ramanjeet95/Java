package threads.commonproblems;

import java.util.concurrent.Semaphore;
/*
* Using two semaphores approach, one for odd and one for even, we can control the execution flow of two threads to print odd and even numbers in sequence.
* The odd thread will acquire the odd semaphore and print an odd number, then release the even semaphore to allow the even thread to print the next even number.
* This process continues until both threads have printed their respective numbers up to a specified limit.
* */
public class OddEvenPrinterSemaphore {

    static void main() {
        Semaphore oddSemaphore = new Semaphore(1);
        Semaphore evenSemaphore = new Semaphore(0);
        new Thread(new OddPrinter(oddSemaphore, evenSemaphore, 100)).start();
        new Thread(new EvenPrinter(oddSemaphore, evenSemaphore, 100)).start();
    }
}

class OddPrinter implements Runnable {
    private final int MAX_NUM;
    private final Semaphore oddSemaphore;
    private final Semaphore evenSemaphore;

    public OddPrinter(Semaphore oddSemaphore, Semaphore evenSemaphore, int MAX_NUM) {
        this.oddSemaphore = oddSemaphore;
        this.evenSemaphore = evenSemaphore;
        this.MAX_NUM = MAX_NUM;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= MAX_NUM; i+=2) {
                oddSemaphore.acquire();
                System.out.println(i + " " + Thread.currentThread().getName());
                evenSemaphore.release();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class EvenPrinter implements Runnable {
    private final int MAX_NUM;
    private final Semaphore oddSemaphore;
    private final Semaphore evenSemaphore;

    public EvenPrinter(Semaphore oddSemaphore, Semaphore evenSemaphore, int MAX_NUM) {
        this.oddSemaphore = oddSemaphore;
        this.evenSemaphore = evenSemaphore;
        this.MAX_NUM = MAX_NUM;
    }

    @Override
    public void run() {
        try {
            for (int i = 2; i <= MAX_NUM; i+=2) {
                evenSemaphore.acquire();
                System.out.println(i + " " + Thread.currentThread().getName());
                oddSemaphore.release();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
