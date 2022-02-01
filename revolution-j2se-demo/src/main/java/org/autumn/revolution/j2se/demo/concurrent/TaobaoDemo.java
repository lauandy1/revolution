package org.autumn.revolution.j2se.demo.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * 提供一个容器，2个方法，add和size
 * 2个线程，线程1add1到10，线程2观察线程1size到5时停止
 */
public class TaobaoDemo {

    List<Integer> list = new ArrayList<>();
    public void add(int val){
        list.add(val);
    }
    public int size(){
        return list.size();
    }

    public static void m1(){
        TaobaoDemo taobaoDemo = new TaobaoDemo();
        Thread t1 = new Thread(() -> {
            for(int i = 0; i < 10; i++){
                taobaoDemo.add(i);
                System.out.println("放入第" + i + "个元素");
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        });
        Thread t2 = new Thread(() -> {
            while (true){
                if(taobaoDemo.size() == 5){
                    break;
                }
            }
            System.out.println("线程2退出");
        });
        t1.start();
        t2.start();
    }

    /**
     * wait 和 notify配合
     */
    public static void m2(){
        TaobaoDemo taobaoDemo = new TaobaoDemo();
        Object monitor = new Object();
        new Thread(() -> {
            synchronized (monitor){
                System.out.println("t2启动");
                if(taobaoDemo.size() != 5){
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t2结束");
                monitor.notify();
            }
        }, "t2").start();

        new Thread(() -> {
            synchronized (monitor){
                System.out.println("t1启动");
                for(int i = 0; i < 10; i++){
                    taobaoDemo.add(i);
                    System.out.println("添加第" + i + "个元素");
                    if(i == 5){
                        monitor.notify();
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t1结束");
            }
        }, "t1").start();
    }

    /**
     * countDownLunch
     * 需要两只门栓精确控制
     */
    public static void m3(){
        CountDownLatch countDownLatch1 = new CountDownLatch(1);
        CountDownLatch countDownLatch2 = new CountDownLatch(1);
        TaobaoDemo taobaoDemo = new TaobaoDemo();
        new Thread(() -> {
            System.out.println("t2启动");
            try {
                countDownLatch1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch2.countDown();
            System.out.println("t2结束");
        }, "t2").start();
        new Thread(() -> {
            System.out.println("t1启动");
            for(int i = 0; i < 10; i++){
                taobaoDemo.add(i);
                System.out.println("添加第" + i + "个元素");
                if(i == 5){
                    countDownLatch1.countDown();
                    try {
                        countDownLatch2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
            System.out.println("t1结束");
        }, "t1").start();
    }

    static Thread thread1 = null, thread2 = null;

    /**
     * 经验证，lockSupport好像不行
     */
    public static void m4(){
        TaobaoDemo taobaoDemo = new TaobaoDemo();
        thread2 = new Thread(() -> {
            System.out.println("t2启动");
            if(taobaoDemo.size() != 5){
                LockSupport.park();
            }
            System.out.println("t2结束");
            LockSupport.unpark(thread1);
        }, "t2");
        thread2.start();
        thread1 = new Thread(() -> {
            System.out.println("t1启动");
            for(int i = 0; i < 10; i++){
                taobaoDemo.add(i);
                System.out.println("添加第" + i + "个元素");
                if(taobaoDemo.size() == 5){
                    LockSupport.unpark(thread2);
                    LockSupport.park();
                }
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
            System.out.println("t1结束");
        }, "t1");
        thread1.start();
        LockSupport.unpark(thread1);
    }

    /**
     * 用semaphore
     */
    public static void m5(){
        Semaphore semaphore = new Semaphore(1);
        TaobaoDemo taobaoDemo = new TaobaoDemo();
        thread2 = new Thread(() -> {
            System.out.println("t2启动");
            
            System.out.println("t2结束");
            LockSupport.unpark(thread1);
        }, "t2");
        thread2.start();
        thread1 = new Thread(() -> {
            System.out.println("t1启动");
            for(int i = 0; i < 10; i++){
                taobaoDemo.add(i);
                System.out.println("添加第" + i + "个元素");
                if(taobaoDemo.size() == 5){
                    LockSupport.unpark(thread2);
                    LockSupport.park();
                }
            }
            System.out.println("t1结束");
        }, "t1");
        thread1.start();
    }

    public static void main(String[] args) {
        m4();
    }
}
