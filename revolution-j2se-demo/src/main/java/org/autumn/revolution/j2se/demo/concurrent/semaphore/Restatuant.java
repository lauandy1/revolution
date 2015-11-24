package org.autumn.revolution.j2se.demo.concurrent.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by yangzhichao on 15/10/12.
 */
public class Restatuant {
    private Semaphore seatCountLock;

    public Restatuant(int seatCount) {
        seatCountLock = new Semaphore(seatCount);
    }

    public void welcomeGuest() throws InterruptedException {
        ExecutorService excutor = Executors.newCachedThreadPool();

        for (int i = 1; i <= 11; i++) {
            excutor.execute(new Guest(i, seatCountLock));
        }

        Thread.sleep(1000 * 10);
        excutor.shutdown();

        System.out.println("Still Aviable Seat Count :" + seatCountLock.availablePermits());
    }
}
