package org.autumn.revolution.j2se.demo.concurrent;

import java.util.concurrent.Exchanger;

/**
 * 用于两个线程交换数据
 */
public class ExchangerDemo {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        Thread t1 = new Thread(() -> {
            try {
                System.out.println("T1 get:" + exchanger.exchange("A"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                System.out.println("T2 get:" + exchanger.exchange("B"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();

    }
}
