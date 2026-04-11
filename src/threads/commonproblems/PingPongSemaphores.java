package threads.commonproblems;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Semaphore;

public class PingPongSemaphores {
    static void main() {
        Semaphore pingSemaphore = new Semaphore(1);
        Semaphore pongSemaphore = new Semaphore(0);
        try(ExecutorService executorService = java.util.concurrent.Executors.newFixedThreadPool(2)) {
            executorService.submit(new PingWorker(pingSemaphore, pongSemaphore));
            executorService.submit(new PongWorker(pingSemaphore, pongSemaphore));
        }
    }
}

class PingWorker implements Runnable {
    private final Semaphore pingSemaphore;
    private final Semaphore pongSemaphore;

    public PingWorker(Semaphore pingSemaphore, Semaphore pongSemaphore) {
        this.pingSemaphore = pingSemaphore;
        this.pongSemaphore = pongSemaphore;
    }


    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                pingSemaphore.acquire();
                System.out.println("Ping");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            pongSemaphore.release();
        }
    }
}

class PongWorker implements Runnable {
    private final Semaphore pingSemaphore;
    private final Semaphore pongSemaphore;

    public PongWorker(Semaphore pingSemaphore, Semaphore pongSemaphore) {
        this.pingSemaphore = pingSemaphore;
        this.pongSemaphore = pongSemaphore;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                pongSemaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Pong");
            pingSemaphore.release();
        }
    }
}
