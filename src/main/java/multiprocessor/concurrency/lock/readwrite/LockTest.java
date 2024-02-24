package main.java.multiprocessor.concurrency.lock.readwrite;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockTest {


    public static void main(String[] args) throws Exception {
        ReadWriteLock lock = new ReentrantReadWriteLock();
        ReadWriteLocker readWriteLocker = new ReadWriteLocker(lock);
        for(int i = 1; i <= 10; i++){
            int finalI = i;
            new Thread(()-> {
                try {
                    readWriteLocker.read();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
        Thread.sleep(10000);
        System.out.println("Конец");
    }
}
