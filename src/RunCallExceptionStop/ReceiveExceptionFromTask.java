package RunCallExceptionStop;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ReceiveExceptionFromTask {


    public static void main(String[] args) {

        Callable<Exception> callable = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return e;
            }
            return new Exception();
        };

        FutureTask<Exception> exceptionReturningTask = new FutureTask<>(callable);

        new Thread(exceptionReturningTask).start();

        try {
            if (exceptionReturningTask.get() != null) {
                exceptionReturningTask.get().printStackTrace();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            e.getCause().printStackTrace();
        }
    }
}


