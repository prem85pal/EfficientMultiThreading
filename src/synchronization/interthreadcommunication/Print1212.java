package synchronization.interthreadcommunication;


public class Print1212 {

    public static void main(String args[]) {

        final Task task = new Task();

        new Thread("Print1") {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    task.print1();
                }
            }
        }.start();

        new Thread("Print2") {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    task.print2();
                }
            }
        }.start();


    }

}
