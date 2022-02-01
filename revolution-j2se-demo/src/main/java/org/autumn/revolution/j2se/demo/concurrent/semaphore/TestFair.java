package org.autumn.revolution.j2se.demo.concurrent.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class TestFair {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1, true);
        Thread t1 = new Thread(() -> {
            for(int i = 0; i < 10; i++){
                try {
                    semaphore.acquire();
                    System.out.println("T1第" + i + "遍：" + "A");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for(int i = 0; i < 10; i++){
                try {
                    semaphore.acquire();
                    System.out.println("T2第" + i + "遍：" + "B");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }
        });
        Thread t3 = new Thread(() -> {
            for(int i = 0; i < 10; i++){
                try {
                    semaphore.acquire();
                    System.out.println("T3第" + i + "遍：" + "C");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
