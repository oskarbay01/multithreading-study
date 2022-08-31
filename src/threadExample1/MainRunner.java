package threadExample1;

public class MainRunner {
    public static void main(String[] args) {
        System.out.println("!!!!!! "+Thread.currentThread().getName());
        MyThread myThread = new MyThread();
        myThread.start();

        Thread thread = new Thread(new MyThreadRunnable());
        thread.start();
    }
}

class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println("Hello from MyThread "+Thread.currentThread().getName());
    }
}

class MyThreadRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Hello from MyThreadRunnable "+Thread.currentThread().getName());
    }
}
