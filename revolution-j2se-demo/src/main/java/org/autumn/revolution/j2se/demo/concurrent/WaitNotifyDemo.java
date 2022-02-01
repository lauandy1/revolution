package org.autumn.revolution.j2se.demo.concurrent;

import java.util.concurrent.TimeUnit;

public class WaitNotifyDemo {


    /**
     * 测试等待队列、阻塞队列，是否为FIFO
     * 按顺序：线程1、2、3依次打印，线程1先执行，线程2和3先等待，让2先等
     * 测试，是否先wait的先进队列，并且先出队列
     */
    public static void demo1(){
        Object monitor = new Object();
        // 线程1
        new Thread(() -> {
            synchronized (monitor){
                System.out.println("t1开始");
                // 让出锁
                try {
                    // 先进等待队列
                    System.out.println("t1让出锁");
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t1通知");
                monitor.notifyAll();
                System.out.println("t1结束");
            }
        }, "t1").start();
        // 线程2
        new Thread(() -> {
            synchronized (monitor){
                System.out.println("t2开始");
                try {
                    // 先进等待队列
                    System.out.println("t2进队列");
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t2出队执行");
                System.out.println("t2");
            }
        }, "t2").start();
        // 线程3
        new Thread(() -> {
            try {
                // 先等待1秒，再去抢锁，保证线程2先拿到锁
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (monitor){
                System.out.println("t3开始");
                try {
                    System.out.println("t3进队列");
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t3出队执行");
                System.out.println("t3");
            }
        }, "t3").start();
    }

    public static void main(String[] args) {
        demo1();

    }
}
