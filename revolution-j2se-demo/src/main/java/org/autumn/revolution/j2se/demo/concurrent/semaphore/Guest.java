package org.autumn.revolution.j2se.demo.concurrent.semaphore;

import java.util.concurrent.Semaphore;

/**
 * Created by yangzhichao on 15/10/12.
 */
public class Guest implements Runnable {

    private int id;

    private Semaphore seatCountLock;

    public Guest(int id, Semaphore seatCountLock) {
        this.id = id;
        this.seatCountLock = seatCountLock;
    }
    public void takeSeat() {
        System.out.println("Guest [ " + id + " ] Take Seat Now");
    }

    public void leave() {
        System.out.println("Guest [ " + id + " ] Leave Now");
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        try {
            System.out.println("About " + seatCountLock.getQueueLength() + " Guest Are Waiting");
            seatCountLock.acquire();
            takeSeat();
            Thread.sleep(100);
            leave();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            seatCountLock.release();
        }


    }
}
