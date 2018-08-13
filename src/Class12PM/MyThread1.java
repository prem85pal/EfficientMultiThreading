package Class12PM;


public class MyThread1 extends Thread {

    @Override
    public void run() {

        Thread.currentThread().setName("t1");
        System.out.println("Hi   " + Thread.currentThread().getName());

    }

    @Override
    public synchronized void start() {
        super.start();
    }
}
