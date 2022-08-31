package threadLifeCycle;

public class MainRunner {
    public static void main(String[] args) {
        System.out.println("!!!!!! " + Thread.currentThread().getName());
        MyThread myThread = new MyThread();
        myThread.start();

        MyThreadRunnable r1 = new MyThreadRunnable();
        Thread thread = new Thread(r1);
        thread.start();

        Thread thread2 = new Thread(r1);
        thread2.start();

        System.out.println("Main thread is dead");
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i + " " + Thread.currentThread().getName());
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
