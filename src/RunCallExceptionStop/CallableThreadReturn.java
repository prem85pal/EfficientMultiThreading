package RunCallExceptionStop;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class EmpA implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "Prem";
    }
}

public class CallableThreadReturn {

    public static void main(String[] args) {

        FutureTask<String> task = new FutureTask<>(new EmpA());
        new Thread(task).start();

        try {
            System.out.println(task.get());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            e.getCause().printStackTrace();
        }
    }
}

