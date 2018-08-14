package Class12PM;


import java.util.Arrays;
import java.util.List;

import static java.lang.Thread.MAX_PRIORITY;
import static java.lang.Thread.yield;

public class CreateThread1 {

    public static void main(String[] args) {


        Thread thread1 = new Thread("t1") {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(i + " " + Thread.currentThread().getName());

                }
            }
        };
        thread1.start();




        Thread thread3 = new Thread("t3") {
            @Override
            public void run() {
                try {
                    thread1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 10; i++) {
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(i + " " + Thread.currentThread().getName());

                }
            }
        };
        thread3.start();
        thread3.setPriority(MAX_PRIORITY);


        Thread thread2 = new Thread("t2") {
            @Override
            public void run() {
                try {
                    thread1.join(5000);
                    thread3.join(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 10; i++) {
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(i + " " + Thread.currentThread().getName());

                }
            }
        };
        thread2.start();


        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Asynchronous runnable task");
            }
        };

        List<String> arrayList = Arrays.asList("a", "b", "c");

        for (String str : arrayList) {
            System.out.println(str);
        }

        arrayList.stream().forEach((str) -> {
            System.out.println(str);
        });

    }

}
