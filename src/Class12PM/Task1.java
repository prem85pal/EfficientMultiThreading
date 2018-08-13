package Class12PM;


public class Task1 implements Runnable {

    @Override
    public void run() {

        System.out.println("Task1   " + Thread.currentThread().getName());
    }
}
