package ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class DaemonThreadsUsingExecutors {


    public static void main(String[] args) {


        ExecutorService execService = Executors.newCachedThreadPool(new ThreadFactory() {

            @Override
            public Thread newThread(Runnable runnable) {
                Thread thread = Executors.defaultThreadFactory().newThread(runnable);
                thread.setDaemon(true);
                return thread;
            }

        });

        execService.execute(() -> {
            System.out.println("Logic of thread");
            System.out.println(Thread.currentThread().isDaemon());
        });

        execService.shutdown();

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5, new ThreadFactory() {

            @Override
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                thread.setDaemon(true);
                return thread;
            }

        });

        fixedThreadPool.execute(() -> {
            System.out.println("Logic of thread");
            System.out.println(Thread.currentThread().isDaemon());
            System.out.println(Thread.currentThread().getName());
        });

        fixedThreadPool.execute(() -> {
            System.out.println("Logic of thread");
            System.out.println(Thread.currentThread().isDaemon());
            System.out.println(Thread.currentThread().getName());
        });

        fixedThreadPool.shutdown();

    }

}
