package ExecutorService;


import java.util.concurrent.*;

public class ExecutorServiceMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        final ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.execute(new Runnable() {
            public void run() {
                System.out.println("Asynchronous task execute");
            }
        });

        executorService.execute(() -> {
            System.out.println("Asynchronous task execute");
        });

        // Lambda Runnable
        Runnable rTask = () -> {
            System.out.println("Asynchronous task submit runnable");
        };
        Future rFuture = executorService.submit(rTask);
        rFuture.get();  //returns null if the task has finished correctly.

        Callable cTask = () -> {
            System.out.println("Asynchronous Callable");
            return "Callable Result";
        };
        Future cFuture = executorService.submit(cTask);

        System.out.println("future.get() = " + cFuture.get());
        executorService.shutdown();
    }
}
