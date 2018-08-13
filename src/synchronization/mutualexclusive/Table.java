package synchronization.mutualexclusive;


public class Table {

    synchronized  void printTable(int n) {

        System.out.println("Current Thread:-" + Thread.currentThread().getName());
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
