package com.domalchuk.s4;

public class MySyncThread {
    public void inc1() throws InterruptedException {
        synchronized (this) {
            System.out.println("start1");
            System.out.println("wait");
            wait();
            System.out.println("continue");
        }
    }

    public void inc2() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this) {
            System.out.println("start2");
            notify();
            System.out.println("notify");
        }
    }
}
