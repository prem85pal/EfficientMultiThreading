package synchronization.mutualexclusive.synchronizedblock;


class Table {

    void printTable(int n) {
        synchronized (this) {//synchronized block
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
    }//end of the method
}

class Task2Table extends Thread {
    Table t;

    Task2Table(Table t) {
        this.t = t;
    }

    public void run() {
        t.printTable(2);
    }

}

class Task5Table extends Thread {
    Table t;

    Task5Table(Table t) {
        this.t = t;
    }

    public void run() {
        t.printTable(100);
    }
}

class SyncBlock {
    public static void main(String args[]) {
        Table obj = new Table();//only one object
        Task2Table t1 = new Task2Table(obj);
        Task5Table t2 = new Task5Table(obj);
        t1.start();
        t2.start();
    }
}