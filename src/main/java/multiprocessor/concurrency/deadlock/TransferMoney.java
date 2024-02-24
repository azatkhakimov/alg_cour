package main.java.multiprocessor.concurrency.deadlock;

import java.math.BigDecimal;

/*
Пример дедлока из-за динамического порядка следования блокировок
*/
public class TransferMoney {
    public void transferMoney(Account fromAccount, Account toAccount, DollarAmount amount){
        synchronized (fromAccount){
            synchronized (toAccount){
                if(fromAccount.getBalance().compareTo(amount.getValue()) < 0){
                    throw new RuntimeException();
                }else{
                    fromAccount.debit(amount);
                    toAccount.credit(amount);
                }
            }
        }
    }


    interface Account{
        BigDecimal getBalance();

        void debit(DollarAmount amount);

        void credit(DollarAmount amount);
    }
    interface DollarAmount{
        BigDecimal getValue();
    }
}
