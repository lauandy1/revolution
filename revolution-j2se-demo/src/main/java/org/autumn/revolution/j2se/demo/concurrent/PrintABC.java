package org.autumn.revolution.j2se.demo.concurrent;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by yangzhichao on 15/10/11.
 */
public class PrintABC {

    public static String flag = "A";

    public static void print1(){
        final Object monitor = new Object();

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for(int i=0;i<10;i++){
                            synchronized(monitor){
                                while(!flag.equals("A")){
                                    try {
                                        monitor.wait();
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                                System.out.println("A");
                                flag = "B";
                                monitor.notifyAll();
                            }
                        }
                    }
                }
        ).start();

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for(int i=0;i<10;i++){
                            synchronized(monitor){
                                while(!flag.equals("B")){
                                    try {
                                        monitor.wait();
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                                System.out.println("B");
                                flag = "C";
                                monitor.notifyAll();
                            }
                        }
                    }
                }
        ).start();

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for(int i=0;i<10;i++){
                            synchronized(monitor){
                                while(!flag.equals("C")){
                                    try {
                                        monitor.wait();
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                                System.out.println("C");
                                flag = "A";
                                monitor.notifyAll();
                            }
                        }
                    }
                }
        ).start();
    }

    /**
     * 第二种方式，用lockSupport
     */
    public static void print2(){
        Thread t1 = new Thread(() -> {
            for(int i = 0; i < 10; i++){
                System.out.println("第" + i + "遍：A");
                LockSupport.park();

            }
        });
    }

    public static void main(String[] args) {

    }
}
