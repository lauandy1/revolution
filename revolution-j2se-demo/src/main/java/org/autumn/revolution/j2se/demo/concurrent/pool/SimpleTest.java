package org.autumn.revolution.j2se.demo.concurrent.pool;

import java.util.concurrent.*;

/**
 * Created by yangzhic on 2016/1/4.
 */
public class SimpleTest {

    private static final ExecutorService executorService = Executors.newCachedThreadPool();

    private static void doTask(){
        while (true){
            //System.out.println("task is running...");
            if(Thread.interrupted()){
                System.out.println("thread is interrupted");
                break;
            }
        }
        System.out.println("do task success");
    }



    public static void main(String[] args) {

        Boolean result = false;

        Future<Boolean> future = executorService.submit(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                doTask();
                return true;
            }
        });

        try {
            result = future.get(2, TimeUnit.SECONDS);
            System.out.println("result is :"+result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            System.out.println("time is out");
            System.out.println("result is :"+result);
            future.cancel(true);
        }


    }
}
