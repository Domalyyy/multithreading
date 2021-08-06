package com.domalchuk.s4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Process {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public void producer1() throws InterruptedException {
        lock.lock();
        System.out.println("Produces1 start");
        System.out.println("Produces1 wait");
        condition.await();
        System.out.println("Produces1 continue");
        lock.unlock();
    }

//    public void producer2() throws InterruptedException {
//        lock.lock();
//        System.out.println("Produces2 start");
//        System.out.println("Produces2 wait");
//        condition.await();
//        System.out.println("Produces2 continue");
//        lock.unlock();
//    }

    public void consumer() {
        lock.lock();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Consumer start");
        condition.signalAll();
        lock.unlock();
    }

}
