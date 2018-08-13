package RunCallExceptionStop;


public class StopThread {

    public static void main(String[] args) {

        StopTask stopTask = new StopTask();
        new Thread(stopTask).start();
        try {
            Thread.sleep(100);
            Thread.currentThread().setPriority(10);
        } catch (InterruptedException ex) {
            System.out.println("Exception");
        }
        stopTask.exit(true);
    }
}


class StopTask implements Runnable {

    private boolean exist = false;

    public void exit(boolean bExit) {
        this.exist = bExit;
    }

    @Override
    public void run() {
        while (!exist) {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread is running");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    System.out.println("Exception");
                }
            }
        }
        System.out.println("Thread has been stopped");
    }
}