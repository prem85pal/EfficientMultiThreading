package synchronization.mutualexclusive;

class Table {

    synchronized static void printTableStatic(int n) {
        System.out.println("CT: -" + Thread.currentThread().getName());
        printTable1(n);
    }

    synchronized void printTableNonStatic(int n) {
        System.out.println("CT:-" + Thread.currentThread().getName());
        printTable1(n);
    }

    void printTableBlockSync(int n) {
        synchronized (this) {
            System.out.println("CT:-" + Thread.currentThread().getName());
            printTable1(n);
        }
    }

    private static void printTable1(int n) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(n * i);
            try {
                Thread.sleep(400);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
