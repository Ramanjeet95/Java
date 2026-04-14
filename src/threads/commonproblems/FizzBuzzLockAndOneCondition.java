package threads.commonproblems;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FizzBuzzLockAndOneCondition {
    static void main() {
        int n = 150;
        FizzBuzzHolder fizzBuzzHolder = new FizzBuzzHolder(n);
        new Thread(fizzBuzzHolder::fizz).start();
        new Thread(fizzBuzzHolder::buzz).start();
        new Thread(fizzBuzzHolder::fizzbuzz).start();
        new Thread(fizzBuzzHolder::number).start();
    }
}

class FizzBuzzHolder {
    private final int n;
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private int current = 1;

    public FizzBuzzHolder(int n) {
        this.n = n;
    }

    public void fizz() {
        while (current <= n) {
            lock.lock();
            try {
                while (current <= n && !(current % 3 == 0 && current % 5 != 0)) {
                    condition.await();
                }
                if (current > n) return;
                System.out.println("fizz");
                current++;
                condition.signalAll();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }

    public void buzz() {
        while (current <= n) {
            lock.lock();
            try {
                while (current <= n && !(current % 3 != 0 && current % 5 == 0)) {
                    condition.await();
                }
                if (current > n) return;
                System.out.println("buzz");
                current++;
                condition.signalAll();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }

    public void fizzbuzz() {
        while (current <= n) {
            lock.lock();
            try {
                while (current <= n && !(current % 3 == 0 && current % 5 == 0)) {
                    condition.await();
                }
                if (current > n) return;
                System.out.println("fizzbuzz");
                current++;
                condition.signalAll();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }

    public void number() {
        while (current <= n) {
            lock.lock();
            try {
                while (current <= n && !(current % 3 != 0 && current % 5 != 0)) {
                    condition.await();
                }
                if (current > n) return;
                System.out.println(current);
                current++;
                condition.signalAll();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }
}
