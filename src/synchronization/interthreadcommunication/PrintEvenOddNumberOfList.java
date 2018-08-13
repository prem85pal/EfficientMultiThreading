package synchronization.interthreadcommunication;


import java.util.Arrays;
import java.util.List;

public class PrintEvenOddNumberOfList {

    public static void main(String[] args) {

        Integer[] a = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        final List<Integer> al = Arrays.asList(a);

       /* new Thread("T1-Thread-OddPrint") {
            @Override
            public void run() {
                synchronized (al) {
                    System.out.println(Thread.currentThread().getName());
                    for (Integer integer : al) {
                        if (integer % 2 != 0) {
                            System.out.println(integer);
                            try {
                                sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }.start();

        new Thread("T2-Thread-EvenPrint") {
            @Override
            public void run() {
                synchronized (al) {
                    System.out.println(Thread.currentThread().getName());
                    for (Integer integer : al) {
                        if (integer % 2 == 0) {
                            System.out.println(integer);
                            try {
                                sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }.start();*/


        new Thread("T1-Thread-OddPrint") {
            @Override
            public void run() {
                synchronized (al) {
                    System.out.println(Thread.currentThread().getName());
                    al.stream().forEach(integer -> {
                        if (integer % 2 != 0) {
                            System.out.println(integer);
                            try {
                                sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    });

                }
            }
        }.start();


        new Thread("T2-Thread-EvenPrint") {
            @Override
            public void run() {
                synchronized (al) {
                    System.out.println(Thread.currentThread().getName());
                    for (Integer integer : al) {
                        if (integer % 2 == 0) {
                            System.out.println(integer);
                            try {
                                sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }.start();

    }
}
