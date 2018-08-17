//What is BlockingQueue. advantage and disadvantage

package synchronization.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class ProducerConsumerService {

    public static void main(String[] args) {

        BlockingQueue<Message> queue = new ArrayBlockingQueue<>(10);
        BlockingQueue<ComparableObj> queue1 = new PriorityBlockingQueue<>(10);

        new Thread(() -> {

            for (int i = 0; i < 10; i++) {
                Message msg = new Message("" + i);
                try {
                    Thread.sleep(i);
                    queue.put(msg);
                    System.out.println("Produced " + msg.getMsg());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Message msg = new Message("exit");
            try {
                queue.put(msg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Producer").start();


        new Thread(() -> {
            try {
                Message msg;
                while (!"exit".equals((msg = queue.take()).getMsg())) {
                    Thread.sleep(10);
                    System.out.println("Consumed " + msg.getMsg());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, "Consumer").start();

        System.out.println("Producer and Consumer has been started");
    }


}
