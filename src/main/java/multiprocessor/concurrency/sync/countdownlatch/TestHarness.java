package main.java.multiprocessor.concurrency.sync.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class TestHarness {

    public static void main(String[] args) throws InterruptedException {
        TestHarness testHarness = new TestHarness();
        long l = testHarness.timeTasks(5, () -> System.out.println("Hello from " + Thread.currentThread().getName()));
        System.out.println(l);
    }

    public long timeTasks(int nThreads, final Runnable task) throws InterruptedException{
        final CountDownLatch startGate = new CountDownLatch(1);
        System.out.println("startGate created: "+startGate.getCount());
        final CountDownLatch endGate  =new CountDownLatch(nThreads);
        System.out.println("endGate created: "+endGate.getCount());
        for (int i = 0; i < nThreads; i++) {
            Thread thread = new Thread(() -> {
                try {
                    System.out.println("Thread awaits the startGate "+ Thread.currentThread().getName());
                    startGate.await();
                    System.out.println("Thread passed startGate " + Thread.currentThread().getName());
                    try {
                        task.run();
                    }finally {
                        endGate.countDown();
                        System.out.println("Thread: "+Thread.currentThread().getName() + " counted down endGate " + endGate.getCount());
                    }
                } catch (InterruptedException e) {
                }
            });
            thread.start();
        }
        long start = System.nanoTime();
        Thread.sleep(2000);
        startGate.countDown();
        System.out.println("startGate was counted Down");

        System.out.println("waiting end gate to count Down");
        endGate.await();
        long end = System.nanoTime();
        return end-start;
    }
}
