package synchronization.mutualexclusive;


public class TestStaticMethod {

    public static void main(String t[]) {

        new Thread(() -> {
            Table.printTableStatic(1);
        }, "t1").start();

        new Thread(() -> {
            Table.printTableStatic(2);
        }, "t2").start();


        final Table table1 = new Table();

        new Thread(() -> {
            table1.printTableNonStatic(3);
        }, "t3").start();

        new Thread(() -> {
            table1.printTableBlockSync(4);
        }, "t3").start();
    }
}
