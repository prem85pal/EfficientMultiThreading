package synchronization.interthreadcommunication;


public class TestITC {

    public static void main(String args[]) {

        final Customer c = new Customer();

        new Thread("WithdrawThread") {
            public void run() {
                c.withdraw(15000);
            }
        }.start();

        new Thread("DepositThread") {
            public void run() {
                c.deposit(10000);
            }
        }.start();
    }
}