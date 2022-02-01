package org.autumn.revolution.j2se.demo.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 两个线程，一个线程向list里放数据，另一个线程观察list数量达到5时停止
 */
public class MonitorTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(10);
        Object monitor = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (monitor){
                for(int i = 0; i < 5; i++){
                    list.add(i);
                    System.out.println(i);
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(i == 4){
                        monitor.notify();
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (monitor){
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("list size is : " + list.size());
                monitor.notify();
            }
        });
        t2.start();
        t1.start();
    }
}
