package synchronization.interthreadcommunication;


import java.util.Vector;

public class ProducerConsumerSolution {


    public static void main(String args[]) {

        Vector<Integer> sharedQueue = new Vector<>();
        int size = 4;

        Runnable producer = () -> {
            for (int i = 0; i < 7; i++) {
                System.out.println("Produced: " + i);
                try {
                    while (sharedQueue.size() == size) {
                        synchronized (sharedQueue) {
                            System.out.println("Queue is full " + Thread.currentThread().getName()
                                    + " is waiting , size: " + sharedQueue.size());

                            sharedQueue.wait();
                        }
                    }
                    synchronized (sharedQueue) {
                        sharedQueue.add(i);
                        sharedQueue.notifyAll();
                    }
                } catch (InterruptedException ex) {

                }
            }
        };
        new Thread(producer, "producer").start();


        Runnable consumer = () -> {
            while (true) {
                try {
                    //wait if queue is empty
                    while (sharedQueue.isEmpty()) {
                        synchronized (sharedQueue) {
                            System.out.println("Queue is empty " + Thread.currentThread().getName()
                                    + " is waiting , size: " + sharedQueue.size());

                            sharedQueue.wait();
                        }
                    }
                    //Otherwise consume element and notify waiting producer
                    synchronized (sharedQueue) {
                        sharedQueue.notifyAll();
                        System.out.println("Consumed: " + sharedQueue.remove(0));
                    }
                    Thread.sleep(50);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        };

        new Thread(consumer, "consumer").start();
    }
}
