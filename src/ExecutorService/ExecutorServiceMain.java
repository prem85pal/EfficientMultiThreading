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
            System.out.println("Asynchronous runnable task");
        });

        // Lambda Runnable
        Runnable rTask = () -> {
            System.out.println("Asynchronous runnable task");
        };
        Future rFuture = executorService.submit(rTask);
        rFuture.get();  //returns null if the task has finished correctly.

        Callable cTask = () -> {
            System.out.println("Asynchronous Callable task");
            return "Callable Result";
        };
        Future cFuture = executorService.submit(cTask);

        System.out.println("future.get() = " + cFuture.get());
        executorService.shutdown();
    }
}


/*
* Executor.execute() vs ExecutorService.submit() method
*
1) Both submit() and execute() methods are used to submit a task to Executor framework for asynchronous execution.
2) Both submit() and execute() can accept a Runnable task.
3) You can access submit() and execute() from the ExecutorService interface because it also extends the Executor interface which declares the execute() method.
Apart from the fact that submit() method can return output and execute() cannot, following are other notable differences between these two key methods of Executor framework of Java 5.
1) The submit() can accept both Runnable and Callable task but execute() can only accept the Runnable task.
2) The submit() method is declared in ExecutorService interface while execute() method is declared in the Executor interface.
3) The return type of submit() method is a Future object but return type of execute() method is void.
* */