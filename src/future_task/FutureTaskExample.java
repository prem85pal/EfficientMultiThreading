package future_task;

import java.util.concurrent.*;

public class FutureTaskExample {

    public static void main(String[] args) {


        Callable<String> callable1 = () -> {
            Thread.sleep(200);
            return Thread.currentThread().getName();
        };

        Callable<String> callable2 = () -> {
            Thread.sleep(400);
            return Thread.currentThread().getName();
        };

        FutureTask<String> futureTask1 = new FutureTask<String>(callable1);
        FutureTask<String> futureTask2 = new FutureTask<String>(callable2);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future future1 = executor.submit(futureTask1);
        Future future2 = executor.submit(futureTask2);

        try {
            System.out.println(future1.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(future2.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
