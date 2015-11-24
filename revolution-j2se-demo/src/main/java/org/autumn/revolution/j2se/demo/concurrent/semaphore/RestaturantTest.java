package org.autumn.revolution.j2se.demo.concurrent.semaphore;

/**
 * Created by yangzhichao on 15/10/12.
 */
public class RestaturantTest {

    public static void main(String[] args) throws InterruptedException {

        final Restatuant restatuant = new Restatuant(5);


        restatuant.welcomeGuest();
    }
}
