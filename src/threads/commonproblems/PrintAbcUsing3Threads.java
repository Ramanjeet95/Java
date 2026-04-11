package threads.commonproblems;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class PrintAbcUsing3Threads {
    static void main() {
        Semaphore aSemaphore = new Semaphore(1);
        Semaphore bSemaphore = new Semaphore(0);
        Semaphore cSemaphore = new Semaphore(0);
        try {
            ExecutorService executorService = Executors.newFixedThreadPool(3);
            executorService.submit(new APrinter(aSemaphore, bSemaphore, 10));
            executorService.submit(new BPrinter(bSemaphore, cSemaphore, 10));
            executorService.submit(new CPrinter(cSemaphore, aSemaphore, 10));
            executorService.shutdown();

            executorService.awaitTermination(1, java.util.concurrent.TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class APrinter implements Runnable {
    private final Semaphore aSemaphore;
    private final Semaphore bSemaphore;
    private final int limit;

    public APrinter(Semaphore aSemaphore, Semaphore bSemaphore, int limit) {
        this.aSemaphore = aSemaphore;
        this.bSemaphore = bSemaphore;
        this.limit = limit;
    }


    @Override
    public void run() {
        for (int i = 0; i < limit; i++) {
            try {
                aSemaphore.acquire();
                System.out.println("A");
                bSemaphore.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class BPrinter implements Runnable {
    private final Semaphore bSemaphore;
    private final Semaphore cSemaphore;
    private final int limit;

    public BPrinter(Semaphore bSemaphore, Semaphore cSemaphore, int limit) {
        this.bSemaphore = bSemaphore;
        this.cSemaphore = cSemaphore;
        this.limit = limit;
    }

    @Override
    public void run() {
        for (int i = 0; i < limit; i++) {
            try {
                bSemaphore.acquire();
                System.out.println("B");
                cSemaphore.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class CPrinter implements Runnable {
    private final Semaphore cSemaphore;
    private final Semaphore aSemaphore;
    private final int limit;

    public CPrinter(Semaphore cSemaphore, Semaphore aSemaphore, int limit) {
        this.cSemaphore = cSemaphore;
        this.aSemaphore = aSemaphore;
        this.limit = limit;
    }

    @Override
    public void run() {
        for (int i = 0; i < limit; i++) {
            try {
                cSemaphore.acquire();
                System.out.println("C");
                System.out.println();
                aSemaphore.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}