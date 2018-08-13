package synchronization.mutualexclusive;


public class Print_T1_2_T2_3_T3_4 {


    public static void main(String[] args) {

        final Table table = new Table();

        final int a = 2;
        Thread t1 = new Thread(() -> {
            table.printTable(a);
        }, "t1");

        Thread t2 = new Thread(() -> {
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            table.printTable(3);
        }, "t2");

        Thread t3 = new Thread(() -> {
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            table.printTable(4);
        }, "t3");

        t1.start();
        t2.start();
        t3.start();
    }

}
