package synchronization.atomicinteger;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {

    public static void main(String[] args) {

        AtomicInteger i = new AtomicInteger(5);
        System.out.println(i.get());

        System.out.println("++i is " + i.incrementAndGet());
        System.out.println("i++ is " + i.getAndIncrement());
        System.out.println(i.get());

        System.out.println("--i is " + i.decrementAndGet());
        System.out.println("i-- is " + i.getAndDecrement());
        System.out.println(i.get());

        i.set(10);
        System.out.println("x = i is " + i.get());
    }
}
