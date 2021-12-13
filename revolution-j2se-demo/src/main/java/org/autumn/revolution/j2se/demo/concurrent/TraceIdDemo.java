package org.autumn.revolution.j2se.demo.concurrent;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlRunnable;
import com.alibaba.ttl.threadpool.TtlExecutors;

import java.util.concurrent.*;

/**
 * 描述：TODO
 * Author: yangzhichao
 * Date: 2021/12/11
 */
public class TraceIdDemo {

    public static void main(String[] args) {
//        ThreadLocal<String> threadLocal = new ThreadLocal<>();
//        threadLocal.set("traceId:1001");
//        new Thread(() -> {
//            System.out.println(threadLocal.get());
//        }).start();
//
//
        InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
        inheritableThreadLocal.set("traceId:1001");
//        new Thread(() -> {
//            System.out.println(inheritableThreadLocal.get());
//        }).start();

        ThreadLocal<String> TTL = new TransmittableThreadLocal<>();
        TTL.set("traceId:1002");

        //ExecutorService executorService = new ThreadPoolExecutor(2, 4, 10000, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10), Executors.defaultThreadFactory());
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        //executorService = TtlExecutors.getTtlExecutorService(executorService);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(TTL.get());
                //System.out.println(inheritableThreadLocal.get());
            }
        });

    }
}
