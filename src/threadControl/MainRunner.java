package threadControl;

public class MainRunner {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("!" + Thread.currentThread().getName());
        MyThread myThread = new MyThread();
        myThread.start();

        // Thread.sleep(1000);
        myThread.join();

        MyThreadRunnable r1 = new MyThreadRunnable();
        Thread thread = new Thread(r1);
        thread.start();


        System.out.println("Main thread is dead");
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i + " " + Thread.currentThread().getName());
            //  Thread.yield();
        }
    }
}

class MyThreadRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i + " " + Thread.currentThread().getName());
        }
    }
}
