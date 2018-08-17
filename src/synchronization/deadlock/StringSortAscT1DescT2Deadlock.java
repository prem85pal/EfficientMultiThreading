package synchronization.deadlock;


import java.util.Arrays;
import java.util.List;

public class StringSortAscT1DescT2Deadlock {

    public static void main(String[] args) {

        final String resource1 = "abc1";
        final String resource2 = "abc2";

        Runnable runnable = () -> {
            synchronized (resource1) {
                System.out.println("Thread 1: locked resource 1");
                String[] strings = resource1.split("");
                List<String> list = Arrays.asList(strings);
                list.sort((String::compareTo));
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                }
                synchronized (resource2) {
                    System.out.println("Thread 1: locked resource 2");
                }
            }
        };

        Thread t1 = new Thread(runnable);

        // t2 tries to lock resource2 then resource1
        Thread t2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("Thread 2: locked resource 2");
                String[] strings = resource2.split("");
                List<String> list = Arrays.asList(strings);
                list.sort((String::compareTo));
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                }
                synchronized (resource1) {
                    System.out.println("Thread 2: locked resource 1");
                }
            }
        });
        t1.start();
        t2.start();
    }

}
