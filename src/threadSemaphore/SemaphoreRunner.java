package threadSemaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreRunner {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        CheckSemaphore semaphore1 = new CheckSemaphore();
        semaphore1.semaphore = semaphore;
        CheckSemaphore semaphore2 = new CheckSemaphore();
        semaphore2.semaphore = semaphore;
        CheckSemaphore semaphore3 = new CheckSemaphore();
        semaphore3.semaphore = semaphore;
        CheckSemaphore semaphore4 = new CheckSemaphore();
        semaphore4.semaphore = semaphore;
        CheckSemaphore semaphore5 = new CheckSemaphore();
        semaphore5.semaphore = semaphore;

        Thread t1 = new Thread(semaphore1);
        Thread t2 = new Thread(semaphore2);
        Thread t3 = new Thread(semaphore3);
        Thread t4 = new Thread(semaphore4);
        Thread t5 = new Thread(semaphore5);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

    static class CheckSemaphore extends Thread {
        Semaphore semaphore;

        public void run() {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            semaphore.release();
        }
    }
}
