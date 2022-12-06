package conc;

import java.util.HashSet;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, ()->{
            System.out.println("All previous tasks are completed");
        });
        Thread t1 = new Thread(new Task(cyclicBarrier), "T1");
        Thread t2 = new Thread(new Task(cyclicBarrier), "Т2");
        Thread t3 = new Thread(new Task(cyclicBarrier), "Т3");
        if(!cyclicBarrier.isBroken()){
            t1.start();
            t2.start();
            t3.start();
        }
    }
}
class Task implements Runnable{
    private CyclicBarrier cyclicBarrier;

    public Task(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName()+ " is waiting");
            cyclicBarrier.await();
            System.out.println(Thread.currentThread().getName()+ " is release");
        }catch (InterruptedException | BrokenBarrierException e){
            e.printStackTrace();
        }
    }
}