package RunCallExceptionStop;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class RunnableThreadReturn {

    public static void main(String[] args) {

        final String[] result = new String[1];
        FutureTask<String[]> runnableTask = new FutureTask<String[]>(new Runnable() {
            public void run() {
                result[0] = "Prem";
            }

        }, result);

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

class EmpB implements Runnable {

    private String[] result1 = new String[1];

    public String[] getResult1() {
        return result1;
    }

    @Override

    public void run() {
        result1[0] = "Prem";
    }
}
