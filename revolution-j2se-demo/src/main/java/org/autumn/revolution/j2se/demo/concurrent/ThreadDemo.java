package org.autumn.revolution.j2se.demo.concurrent;

import java.util.HashMap;
import java.util.Map;

public class ThreadDemo {

    public void m1(){
        System.out.println("m1");
    }

    public static void test(){
        Object monitor = new Object();
        final Map<String, Integer> map = new HashMap<>(1);
        map.put("flag", 1);
        Thread thread1 = new Thread(() -> {
            for(int i = 0; i < 5; i++){
                synchronized(monitor){
                    if(map.get("flag") == 1){
                        System.out.println("A");
                        map.put("flag", 2);
                    }
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            for(int i = 0; i < 5; i++){
                synchronized(monitor){
                    if(map.get("flag") == 2){
                        System.out.println("B");
                        map.put("flag", 3);
                    }
                }
            }
        });
        Thread thread3 = new Thread(() -> {
            for(int i = 0; i < 5; i++){
                synchronized(monitor){
                    if(map.get("flag") == 3){
                        System.out.println("C");
                        map.put("flag", 1);
                    }
                }
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }

    public static void main(String[] args) {
        ThreadDemo t1 = new ThreadDemo();
        new Thread(t1::m1).start();
    }
}
