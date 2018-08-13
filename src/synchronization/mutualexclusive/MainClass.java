package synchronization.mutualexclusive;


public class MainClass {

    public static void main(String args[]) {

        final Table obj = new Table();

        Thread t1 = new Thread("MyThread-1") {
            public void run() {
                obj.printTable(5);
            }
        };

        Thread t2 = new Thread("MyThread-2") {
            public void run() {
                obj.printTable(2);
            }
        };

        t1.start();
        t2.start();
    }
}
