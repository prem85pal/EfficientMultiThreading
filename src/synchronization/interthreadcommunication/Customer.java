package synchronization.interthreadcommunication;


import tuts.utils.TimeUtils;

public class Customer {

    int amount = 10000;

    synchronized void withdraw(int amount) {
        System.out.println("going to withdraw..." + amount + "  " + Thread.currentThread().getName());
        if (this.amount < amount) {
            System.out.println("Less balance; waiting for deposit..." + this.amount);
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.amount -= amount;
        System.out.println("withdraw completed..." + this.amount);
    }

    synchronized void deposit(int amount) {
        System.out.println("going to deposit..." + Thread.currentThread().getName());
        this.amount += amount;
        System.out.println("deposit completed... " + this.amount);
        notify();
    }

}
