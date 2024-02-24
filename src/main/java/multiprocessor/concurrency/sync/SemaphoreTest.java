package main.java.multiprocessor.concurrency.sync;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadFactory;

//https://stackoverflow.com/questions/14793416/zero-permit-semaphores
public class SemaphoreTest {

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(0);
        semaphore.release();
        semaphore.release();
        semaphore.release();
        System.out.println(semaphore.availablePermits());
    }

}
