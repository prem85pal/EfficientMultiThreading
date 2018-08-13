package RunCallExceptionStop;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ReceiveExceptionFromTask {


    public static void main(String[] args) {

        FutureTask<Exception> exceptionReturningTask = new FutureTask<>(new ExceptionReturnTask());

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


class ExceptionReturnTask implements Callable<Exception> {

    @Override
    public Exception call() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            return e;
        }
        return new Exception();
    }
}