package synchronization.mutualexclusive.staticsynchronization;


class Table {

    synchronized static void printTable(int n) {
        System.out.println("Current Thread:-" + Thread.currentThread().getName());
        for (int i = 1; i <= 10; i++) {
            System.out.println(n * i);
            try {
                Thread.sleep(400);
            } catch (Exception e) {
            }
        }
    }
}

class Task1Table extends Thread {
    public void run() {
        Table.printTable(1);
    }
}

class Task2Table extends Thread {
    public void run() {
        Table.printTable(2);
    }
}

class Task3Table extends Thread {
    public void run() {
        Table.printTable(3);
    }
}

class Task4Table extends Thread {
    public void run() {
        Table.printTable(4);
    }
}


public class TestStaticMethod {

    public static void main(String t[]) {
        Task1Table t1 = new Task1Table();
        Task2Table t2 = new Task2Table();
        Task3Table t3 = new Task3Table();
        Task4Table t4 = new Task4Table();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
