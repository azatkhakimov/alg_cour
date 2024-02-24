package main.java.multiprocessor.concurrency.lock.readwrite;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

public class ReadWriteLocker {
    private ReadWriteLock readWriteLock;
    private Lock readLock;
    private Lock writeLock;

    public ReadWriteLocker(ReadWriteLock readWriteLock) {
        this.readWriteLock = readWriteLock;
        readLock = readWriteLock.readLock();
        writeLock = readWriteLock.writeLock();
    }

    private int count = 1;

    public int read() throws Exception {
        try {
            System.out.println("Поток: "+Thread.currentThread().getName()+ " Пришел на чтение перед локом");
            readLock.lock();
            System.out.println("Поток: "+Thread.currentThread().getName()+ " Взял локу и сейчас произведет чтение");
            Thread.sleep(1000);
            return count;
        } finally {
            System.out.println("Поток: "+Thread.currentThread().getName()+ " Оставил локу на чтение");
            readLock.unlock();
        }
    }

    public void increment(){
        try {
            System.out.println("Поток: "+Thread.currentThread().getName()+ " Пришел на запись перед локом");
            writeLock.lock();
            System.out.println("Поток: "+Thread.currentThread().getName()+ " Взял локу и сейчас произведет запись");
            Thread.sleep(3000);
            count++;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Поток: "+Thread.currentThread().getName()+ " Оставил локу на запись");
            writeLock.unlock();
        }
    }


}
