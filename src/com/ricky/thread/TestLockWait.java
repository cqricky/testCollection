package com.ricky.thread;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by kk on 15-11-11.
 */
public class TestLockWait {
    public static ReentrantLock lock;
    public static Condition trip;

    public static void main(String [] args) {
        lock = new ReentrantLock();
        trip = lock.newCondition();

        CyclicBarrier cb = new CyclicBarrier(6);

        new  ThreadC("tc").start();



        System.out.println(Thread.currentThread().getName() + " after start tc!");
        try {
            Thread.sleep(3000);
            lock.lock();

            System.out.println(Thread.currentThread().getName() + " unpark!");
            trip.signal();
            Thread.sleep(1000);
            lock.unlock();
        } catch (InterruptedException e) {

        } finally {

        }



    }

    static void notifyOtherThread() {
        trip.signal();
    }

    static class ThreadC extends Thread {
        private String name;

        public ThreadC(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(this.name + " start.");
            lock.lock();
            System.out.println(this.name + " locked");
            try {
                Thread.sleep(2000);

                System.out.println(this.name + " start wait");
                trip.await();
                System.out.println(this.name + " end wait");


            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }
}
