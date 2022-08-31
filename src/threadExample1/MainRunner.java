package threadExample1;

public class MainRunner {
    public static void main(String[] args) {
        System.out.println("!!!!!!");
        MyThread myThread = new MyThread();
        myThread.start();
    }
}

class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println("Hello from MyThread");
    }
}
