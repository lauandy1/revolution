package org.autumn.revolution.j2se.demo.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by yangzhichao on 15/9/16.
 */
public class CyclicBarrierDemo extends Thread {

    private CyclicBarrier barrier = null;

    private static AtomicInteger nextId  = new AtomicInteger();

    private int                  id      = 0;

    public CyclicBarrierDemo(CyclicBarrier barrier) {
        id = nextId.incrementAndGet();
        this.barrier = barrier;
    }

    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Gruant " + id + " is waiting");
        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Gruant " + id + " is attacking");
    }

    public static void main(String[] args){
        CyclicBarrier cb = new CyclicBarrier(10);
        for(int i=0;i<10;i++){
            CyclicBarrierDemo graunt = new CyclicBarrierDemo(cb);
            graunt.start();
        }

    }
}
