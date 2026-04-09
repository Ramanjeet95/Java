package threads.commonproblems;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class OneToNUsingMThreads {
    static void main() {
        int m = 5;

        List<Semaphore> semaphoreList = new ArrayList<>();
        semaphoreList.add(new Semaphore(1));
        for(int i = 1; i < m; i++) {
            semaphoreList.add(new Semaphore(0));
        }
        //List<Runnable> runnableList = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            Printer p = new Printer(semaphoreList, i, 17, m);
            //runnableList.add(p);
            new Thread(p).start();
        }
    }
}

class Printer implements Runnable {
    private final List<Semaphore> semaphores;
    private final int threadNumber;
    private final int limit;
    private final int m;

    public Printer(List<Semaphore> semaphores, int threadNumber, int limit, int m) {
        this.semaphores = semaphores;
        this.threadNumber = threadNumber;
        this.limit = limit;
        this.m = m;
    }

    @Override
    public void run() {
        try {
            for(int i = threadNumber; i < limit; i+=m) {
               semaphores.get(threadNumber).acquire();
               Thread.sleep(100);
               System.out.println(i+1 + " " + Thread.currentThread().getName());
               semaphores.get((threadNumber + 1) % m).release();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}