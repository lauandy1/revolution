package org.autumn.revolution.j2se.demo.concurrent;

import org.openjdk.jol.info.ClassLayout;

public class SynchronizedDemo {

    public static class T{
        private int val;
        public int getVal(){
            return val;
        }
        public void setVal(int val){
            this.val = val;
        }
    }

    public static void hashTest(){
        T t = new T();
        System.out.println(ClassLayout.parseInstance(t).toPrintable());
        t.hashCode();
        System.out.println(ClassLayout.parseInstance(t).toPrintable());
    }

    public static void heavyLock() {
        T t = new T();
        System.out.println(ClassLayout.parseInstance(t).toPrintable());
        synchronized (t){
            System.out.println(ClassLayout.parseInstance(t).toPrintable());
            try {
                t.wait();
                System.out.println(ClassLayout.parseInstance(t).toPrintable());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(ClassLayout.parseInstance(t).toPrintable());
    }

    /**
     * 偏向锁测试
     */
    public static void lockBias() throws InterruptedException {
        Thread.sleep(5000);
        T t = new T();
        System.out.println(ClassLayout.parseInstance(t).toPrintable());
    }

    public static void nolock() throws InterruptedException {
        T t = new T();
        System.out.println(ClassLayout.parseInstance(t).toPrintable());
    }


    public static void testLock(){
        T t = new T();
        System.out.println(ClassLayout.parseInstance(t).toPrintable());
        Thread thread1 = new Thread( new Runnable() {
            @Override
            public void run() {
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                synchronized (t){
                    t.setVal(1);
                    System.out.println("thread1");
                    System.out.println(ClassLayout.parseInstance(t).toPrintable());
                }


            }
        });
        Thread thread2 = new Thread( new Runnable() {
            @Override
            public void run() {
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                synchronized (t){
                    t.setVal(2);
                    System.out.println("thread2");
                    System.out.println(ClassLayout.parseInstance(t).toPrintable());
                }
            }
        });
        thread1.start();
        thread2.start();
    }



    public static void main(String[] args) throws InterruptedException {
//        heavyLock();
//        lockBias();
//        hashTest();
//        nolock();
        testLock();

    }
}
