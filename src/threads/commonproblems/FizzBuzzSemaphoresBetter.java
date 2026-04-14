package threads.commonproblems;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
/*
* This is the version with semaphores where each thread signals the thread whose turn is next. There is no driver thread here like the other
* implementation where number thread is the driver. Here each thread is responsible for signaling the next thread to run. This approach is more efficient
* as it eliminates the need for a driver thread to determine which thread should run next, and allows for more direct communication between the threads.
* */
public class FizzBuzzSemaphoresBetter {
    static void main() {
        int n = 150;
        FizzBuzzComponent fizzBuzzComponent = new FizzBuzzComponent(n);
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(fizzBuzzComponent::fizz);
        executorService.submit(fizzBuzzComponent::buzz);
        executorService.submit(fizzBuzzComponent::fizzBuzz);
        executorService.submit(fizzBuzzComponent::number);

        executorService.shutdown();
    }
}

class FizzBuzzComponent {
    private final int n;
    private final Semaphore fizzSemaphore = new Semaphore(0);
    private final Semaphore buzzSemaphore = new Semaphore(0);
    private final Semaphore fizzBuzzSemaphore = new Semaphore(0);
    private final Semaphore numberSemaphore = new Semaphore(1);

    private int current = 1;

    public FizzBuzzComponent(int n) {
        this.n = n;
    }

    public void fizz() {
        while (current <= n) {
            try {
                fizzSemaphore.acquire();
                if(current > n) {
                    return;
                }
                System.out.println("fizz");
                current++;
                signalNext(current);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void buzz() {
        while (current <= n) {
            try {
                buzzSemaphore.acquire();
                if(current > n) {
                    return;
                }
                System.out.println("buzz");
                current++;
                signalNext(current);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void fizzBuzz() {
        while (current <= n) {
            try {
                fizzBuzzSemaphore.acquire();
                if(current > n) {
                    return;
                }
                System.out.println("fizzBuzz");
                current++;
                signalNext(current);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void number() {
        while (current <= n) {
            try {
                numberSemaphore.acquire();
                if(current > n) {
                    return;
                }
                System.out.println(current);
                current++;
                signalNext(current);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void signalNext(int next) {
        if(next <= n) {
            if(next % 3 == 0 && next % 5 == 0) {
                fizzBuzzSemaphore.release();
            } else if(next % 3 == 0) {
                fizzSemaphore.release();
            } else if(next % 5 == 0) {
                buzzSemaphore.release();
            } else {
                numberSemaphore.release();
            }
        } else {
            fizzSemaphore.release();
            buzzSemaphore.release();
            fizzBuzzSemaphore.release();
            numberSemaphore.release();
        }
    }
}
