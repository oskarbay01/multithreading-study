package threadDeadlock;

public class DeadLockRunner {
    public static void main(String[] args) {
        String a = "ABC";
        String b = "CDE";

        Thread t1 = new Thread() {
            public void run() {
                synchronized (a) {
                    System.out.println("A is synchronized from Thread 1");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (b){
                        System.out.println("B is synchronized from Thread 1");
                    }
                }
            }
        };


        Thread t2 = new Thread() {
            public void run() {
                synchronized (b) {
                    System.out.println("B is synchronized from Thread 2");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (a){
                        System.out.println("A is synchronized from Thread 2");
                    }
                }
            }
        };

        t1.start();
        t2.start();
    }
}
