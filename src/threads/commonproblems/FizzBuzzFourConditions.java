package threads.commonproblems;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/*
* This version uses 4 conditions, one for each thread. Instead of having a driver thread which controls the execution, here each thread
* signals the next thread to run after it finishes its task. This way we can avoid the need for a driver thread and allow each thread to control the flow of execution.
* This version is better than the one using only one condition because we only wake up the thread who need to process the next number instead of
* waking up all threads.
* */
public class FizzBuzzFourConditions {
    static void main() {
        int n = 150;
        FizzBuzzCoordinator fizzBuzzCoordinator = new FizzBuzzCoordinator(n);
        new Thread(fizzBuzzCoordinator::fizz).start();
        new Thread(fizzBuzzCoordinator::buzz).start();
        new Thread(fizzBuzzCoordinator::fizzBuzz).start();
        new Thread(fizzBuzzCoordinator::number).start();
    }
}

class FizzBuzzCoordinator {
    private final int n;
    private int current = 1;
    private final Lock lock = new ReentrantLock();
    private final Condition fizzCond = lock.newCondition();
    private final Condition buzzCond = lock.newCondition();
    private final Condition fizzBuzzCond = lock.newCondition();
    private final Condition numberCond = lock.newCondition();

    public FizzBuzzCoordinator(int n) {
        this.n = n;
    }

    public void fizz() {
        while (current <= n) {
            lock.lock();
            try {
                while (current <= n && !(current % 3 == 0 && current % 5 != 0)) {
                    fizzCond.await();
                }
                if(current > n) {
                    return;
                }
                System.out.println("fizz");
                current++;
                signalNext(current);
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
                    buzzCond.await();
                }
                if(current > n) {
                    return;
                }
                System.out.println("buzz");
                current++;
                signalNext(current);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }

    public void fizzBuzz() {
        while (current <= n) {
            lock.lock();
            try {
                while (current <= n && !(current % 3 == 0 && current % 5 == 0)) {
                    fizzBuzzCond.await();
                }
                if(current > n) {
                    return;
                }
                System.out.println("fizzBuzz");
                current++;
                signalNext(current);
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
                while (current <= n && (current % 3 == 0 || current % 5 == 0)) {
                    numberCond.await();
                }
                if (current > n) {
                    return;
                }
                System.out.println(current);
                current++;
                signalNext(current);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }

    private void signalNext(int num) {
        if (num <= n) {
            if (num % 3 == 0 && num % 5 == 0) {
                fizzBuzzCond.signal();
            } else if (num % 3 == 0) {
                fizzCond.signal();
            } else if (num % 5 == 0) {
                buzzCond.signal();
            } else {
                numberCond.signal();
            }
        } else {
            fizzCond.signalAll();
            buzzCond.signalAll();
            fizzBuzzCond.signalAll();
            numberCond.signalAll();
        }
    }
}