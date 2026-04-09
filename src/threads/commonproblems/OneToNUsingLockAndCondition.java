package threads.commonproblems;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OneToNUsingLockAndCondition {
    static void main() {
        int m = 3;
        try (ExecutorService executor = Executors.newFixedThreadPool(m)) {
            Coordinator coordinator = new Coordinator(m);
            for (int i = 0; i < m; i++) {
                executor.submit(new Worker(coordinator, 100, m, i));
            }

        }
    }
}

class Coordinator {
    private final Lock lock = new ReentrantLock();
    private final List<Condition> conditions = new ArrayList<Condition>();
    private volatile int turn = 0;
    private final int m;
    public Coordinator(int m) {
        this.m = m;
        for(int i = 0; i < m; i++) {
            conditions.add(lock.newCondition());
        }
    }

    public void awaitCondition(int index) {
        try {
            lock.lock();
            while (turn != index) {
                conditions.get(index).await();
            }
        } catch (InterruptedException e) {}
        finally {
            lock.unlock();
        }
    }

    public void signalNext(int index) {
        try {
            lock.lock();
            turn = (index + 1) % m;
            conditions.get(turn).signal();
        } finally {
            lock.unlock();
        }
    }
}

class Worker implements Runnable {
    private final Coordinator coordinator;
    private final int limit;
    private final int m;
    private final int id;

    public Worker(Coordinator coordinator, int limit, int m, int id) {
        this.coordinator = coordinator;
        this.limit = limit;
        this.m = m;
        this.id = id;
    }

    @Override
    public void run() {
        for(int i = id; i <= limit; i+=m) {

            coordinator.awaitCondition(id);

            System.out.println(i + " " + Thread.currentThread().getName());

            coordinator.signalNext(id);
        }
    }
}
