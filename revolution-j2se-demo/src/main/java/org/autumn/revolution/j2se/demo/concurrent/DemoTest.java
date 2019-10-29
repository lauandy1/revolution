package org.autumn.revolution.j2se.demo.concurrent;

/**
 * Created by yangzhichao on 17/8/31.
 */
public class DemoTest implements Runnable{

    private int i = 1;
    @Override
    public void run() {
        i++;
        System.out.println(i);
    }

    public static void main(String[] args) {
        DemoTest demoTest = new DemoTest();
        Thread t1 = new Thread(demoTest);
        Thread t2 = new Thread(demoTest);
        t1.start();
        t2.start();
    }
}
