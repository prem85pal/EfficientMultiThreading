package Class12PM;


public class PrintTable234InSequence {

    final static Table table = new Table();

    public static void main(String[] args) {


        Thread thread1 = new Thread(() -> {
            table.printTable(2);
        },"t1");
        thread1.start();


        Thread thread2 = new Thread("t2") {
            @Override
            public void run() {
                try {
                    thread1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                table.printTable(3);
            }
        };
        thread2.start();
        Thread thread3 = new Thread("t3") {
            @Override
            public void run() {
                try {
                    thread1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    thread2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                table.printTable(4);
            }
        };
        thread3.start();
    }
}
