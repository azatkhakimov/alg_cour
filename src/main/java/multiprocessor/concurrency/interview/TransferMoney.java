package main.java.multiprocessor.concurrency.interview;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TransferMoney {


    public static void main(String[] args) throws InterruptedException {
        Wallet[] wallets = new Wallet[10];
        for (int i = 0; i < 10; i++) {
            wallets[i] = new Wallet();
            wallets[i].money.set(100);
        }
        TransferMoney transferMoney = new TransferMoney();
        ExecutorService executors = Executors.newFixedThreadPool(100);

        for (int i = 0; i < 10; i++) {
            int i1 = i % 10;
            Wallet wallet1 = wallets[i1];
            int i2 = (i + 1) % 10;
            Wallet wallet2 = wallets[i2];
            executors.execute(()->{
                System.out.println("Перемещаем деньги от кошелька: "+i1+" к кошельку:" +i2);
                transferMoney.transfer(wallet1, wallet2);});
        }
        executors.shutdown();
        executors.awaitTermination(20, TimeUnit.SECONDS);

    }

    private void transfer(Wallet wallet1, Wallet wallet2) {
        synchronized (wallet1){
            synchronized (wallet2){
                wallet2.money.addAndGet(wallet1.money.get());
                wallet1.money.set(0);
                System.out.println("Денег столько: " + wallet2.money.get() + " thread: " + Thread.currentThread().getName());
            }
        }


    }

    private static class Wallet {
        AtomicInteger money = new AtomicInteger();
    }
}
