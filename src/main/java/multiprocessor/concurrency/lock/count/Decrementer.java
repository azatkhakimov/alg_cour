package main.java.multiprocessor.concurrency.lock.count;

import java.util.concurrent.CountDownLatch;

public class Decrementer implements Runnable{
    CountDownLatch latch = null;

    public Decrementer(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            System.out.println("Начинаем понижение");
            Thread.sleep(1000);
            System.out.println("Понижаем счетчик 1");
            this.latch.countDown();

            Thread.sleep(1000);
            System.out.println("Понижаем счетчик 2");
            this.latch.countDown();

            Thread.sleep(1000);
            System.out.println("Понижаем счетчик 3");
            this.latch.countDown();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
