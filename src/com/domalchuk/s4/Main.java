package com.domalchuk.s4;

public class Main {

    public static void th1() throws InterruptedException {
        final MyThread myThread1 = new MyThread();
        final MyThread myThread2 = new MyThread();

        final Thread thread1 = new Thread(myThread1);
        thread1.start();

        final Thread thread2 = new Thread(myThread2);
        thread2.start();

        thread2.join();
        System.out.println("Finished");
    }

    public static void th2() throws InterruptedException {
        final MySyncThread mySyncThread = new MySyncThread();

        final Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    mySyncThread.inc1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        final Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                mySyncThread.inc2();
            }
        });

        t1.start();
        t2.start();
    }

    public static void th3() {
        final Process process = new Process();

        final Thread t1 = new Thread(() -> {
            try {
                process.producer1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

//        final Thread t3 = new Thread(() -> {
//            try {
//                process.producer2();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });

        final Thread t2 = new Thread(process::consumer);

        t1.start();
//        t3.start();

//        try {
//            t3.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        t2.start();
    }

    public static void main(final String[] args) throws InterruptedException {
//        th1();
//        th2();
        th3();
    }
}
