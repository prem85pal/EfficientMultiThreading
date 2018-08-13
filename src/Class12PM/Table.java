package Class12PM;


public class Table {

    static synchronized void printTable(int n) {
        System.out.println("Current Thread:-" + Thread.currentThread().getName());
        for (int i = 1; i <= 10; i++) {
            System.out.println(n * i + " " + Thread.currentThread().getName());
            try {
                Thread.sleep(400);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
