package synchronization.mutualexclusive;


public class Task5Table implements Runnable {

    private Table table;

    public Task5Table(Table table) {
        this.table = table;
    }

    @Override
    public void run() {
        table.printTable(5);
    }
}
