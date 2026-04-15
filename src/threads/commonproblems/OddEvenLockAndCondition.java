package threads.commonproblems;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OddEvenLockAndCondition {
    private static final Lock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();
    private static int count = 0;

    static void main() {
        int n = 20;
        Runnable evenPrinter = () -> {
            while (true) {
                lock.lock();
                try {
                    while (count <= n && count % 2 != 0) {
                        condition.await();
                    }
                    if (count > n) return;
                    System.out.println(count++);
                    condition.signalAll();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        };

        Runnable oddPrinter = () -> {
            while (true) {
                lock.lock();
                try {

                    while (count <= n && count % 2 == 0) {
                        condition.await();
                    }
                    if (count > n) return;
                    System.out.println(count++);
                    condition.signalAll();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        };
        new Thread(evenPrinter).start();
        new Thread(oddPrinter).start();
    }
}




