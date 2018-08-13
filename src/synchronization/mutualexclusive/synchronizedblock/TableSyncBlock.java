package synchronization.mutualexclusive.synchronizedblock;


public class TableSyncBlock {

    void printTable(int n) {

        synchronized (this) {
            System.out.println("Current Thread:-" + Thread.currentThread().getName() + "this:- " + this);
            for (int i = 1; i <= 10; i++) {
                System.out.println(n * i);
                try {
                    Thread.sleep(400);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }
}


class Use {
    public static void main(String args[]) {
        final TableSyncBlock obj = new TableSyncBlock(); //only one object

        Thread t1 = new Thread("MyThread-1") {
            public void run() {
                obj.printTable(5);
            }
        };
        Thread t2 = new Thread("MyThread-2") {
            public void run() {
                obj.printTable(10);
            }
        };

        t1.start();
        t2.start();
    }
}

