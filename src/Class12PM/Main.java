package Class12PM;


public class Main {


    final static Table table = new Table();
    final static Table table1 = new Table();

    public static void main(String[] args) {

        Thread thread1 = new Thread("t1") {
            @Override
            public void run() {
                table.printTable(2);
            }
        };
        thread1.start();


        Thread thread2 = new Thread("t2") {
            @Override
            public void run() {
                table1.printTable(5);
            }
        };
        thread2.start();


/*
        Thread thread3 = new Thread("t3") {
            @Override
            public void run() {
                table.withoutLock(3);
            }
        };
        thread3.start();

        Thread thread4 = new Thread("t4") {
            @Override
            public void run() {
                table.withoutLock(6);
            }
        };
        thread4.start();*/





    }


}
