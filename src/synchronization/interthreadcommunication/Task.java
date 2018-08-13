package synchronization.interthreadcommunication;


public class Task {

    public synchronized void print1() {
        System.out.println("1");
        notify();
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public synchronized void print2() {

        System.out.println("2");
        notify();
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
