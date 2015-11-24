package org.autumn.revolution.j2se.demo.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ConcurrentTest {
    
    class TaskRunnable implements Runnable{
        
        BlockingQueue<String> queue;

        public void run() {
            // TODO Auto-generated method stub
            try {
                queue.take();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
    }
    
    public PreLoader getPreLoader(){
        return new PreLoader();
    }
    
    private class PreLoader {
        private final FutureTask<String> future = new FutureTask<String>(new Callable<String>() {
            public String call() throws Exception {
                System.out.println("before sleep");
                Thread.sleep(2000);
                System.out.println("after sleep");
                return "success";
            }
        });
        private final Thread thread = new Thread(future);
        public void start(){
            System.out.println(thread);
            thread.start();
        }
        public void interupt(){thread.interrupt();}
        public String get(){
            try {
                return future.get();
            } catch (InterruptedException e){
                System.out.println(e.getCause());
                return "interrupted1";
            }catch (ExecutionException e) {
                System.out.println(e.getCause());
                return "interrupted2";
            }
        }
        
    }

    /**
     * 闭锁demo
     * @param nThreads
     * @param task
     * @return
     * @throws InterruptedException
     */
    public long timeTasks(int nThreads,final Runnable task) throws InterruptedException{
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);
        for(int i=0;i<nThreads;i++){
            Thread t = new Thread(){
                public void run(){
                    System.out.println("outter:"+Thread.currentThread());
                    try{
                        startGate.await();
                        try{
                            task.run();
                        }finally{
                            endGate.countDown();
                        }
                    }catch(InterruptedException ignored){
                        
                    }
                }
            };
            t.start();
        }
        long start = System.nanoTime();
        startGate.countDown();
        endGate.await();
        long end = System.nanoTime();
        return end-start;
    }
    
    
    
    public static void main(String[] args) throws InterruptedException {
        ConcurrentTest concurrentTest = new ConcurrentTest();
//        long time = concurrentTest.timeTasks(3, new Runnable() {
//            public void run() {
//                // TODO Auto-generated method stub
//                System.out.println("inner:"+Thread.currentThread());
//            }
//        });
//        System.out.println(time);

        System.out.println(Thread.currentThread());

        Thread.currentThread().interrupt();
        
        //PreLoader preLoader = concurrentTest.getPreLoader();
        PreLoader preLoader = concurrentTest.new PreLoader();
        preLoader.start();
        //preLoader.interupt();
        System.out.println(preLoader.get());



        
        
        
        
    }

}
