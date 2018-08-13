package synchronization.mutualexclusive;


public class TaskNTableMain {

    public static void main(String[] args) {

        final Table table = new Table();

        Task2Table task2Table = new Task2Table(table);

        Task5Table task5Table = new Task5Table(table);

        Thread thread1 = new Thread(task2Table, "My-Thread1");
        thread1.start();

        Thread thread2 = new Thread(task5Table, "My-Thread2");
        thread2.start();


        final Table table1 = new Table();

        new Thread("My-Thread3") {
            public void run() {
                table1.printTable(6);
            }
        }.start();

        new Thread("My-Thread4") {
            public void run() {
                table1.printTable(7);
            }
        }.start();


    }

}





