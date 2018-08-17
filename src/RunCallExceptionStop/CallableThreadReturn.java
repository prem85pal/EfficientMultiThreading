package RunCallExceptionStop;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableThreadReturn {

    public static void main(String[] args) {

        Callable<String> callable = () -> {
            return "Prem";
        };

        FutureTask<String> task = new FutureTask<>(callable);
        new Thread(task).start();

        try {
            System.out.println(task.get());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            e.getCause().printStackTrace();
        }

        final String[] result = new String[1];
        Runnable runnable = () -> {
            result[0] = "Prem";
        };

        FutureTask<String[]> runnableTask = new FutureTask<String[]>(runnable, result);

        new Thread(runnableTask).start();

        try {
            System.out.println(runnableTask.get()[0]);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            e.getCause().printStackTrace();
        }
    }
}

