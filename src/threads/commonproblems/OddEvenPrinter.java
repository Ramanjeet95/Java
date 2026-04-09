package threads.commonproblems;

public final class OddEvenPrinter {

    private final Object lock = new Object();
    private final int limit;
    private int counter = 0;

    public OddEvenPrinter(int limit) {
        this.limit = limit;
    }

    public static void main(String[] args) {
        OddEvenPrinter printer = new OddEvenPrinter(100);

        Thread evenThread = new Thread(() -> printer.print(true), "Even-Thread");
        Thread oddThread = new Thread(() -> printer.print(false), "Odd-Thread");

        evenThread.start();
        oddThread.start();
    }

    private void print(boolean isEvenThread) {
        try {
            while (true) {
                synchronized (lock) {

                    // Termination check
                    if (counter >= limit) {
                        lock.notifyAll(); // release any waiting threads
                        return;
                    }

                    // Wait until it's this thread's turn
                    while (isEven(counter) != isEvenThread) {
                        lock.wait();
                    }

                    // Print and update state
                    log(counter);
                    counter++;

                    // Signal other thread
                    lock.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // preserve interrupt signal
        }
    }

    private boolean isEven(int number) {
        return (number & 1) == 0; // bitwise check (slightly faster, cleaner)
    }

    private void log(int number) {
        System.out.printf("%d [%s]%n", number, Thread.currentThread().getName());
    }
}