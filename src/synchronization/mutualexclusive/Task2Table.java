package synchronization.mutualexclusive;


public class Task2Table implements Runnable {

    private Table table;

    public Task2Table(Table table) {
        this.table = table;
    }

    @Override
    public void run() {
        table.printTable(2);
    }
}
