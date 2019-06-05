package com.jw.myproject.test.sync;

public class UnsynchBankTest {
    public static final int NACCOUNTS = 10;
    public static final double INITIAL_BALANCE = 2000;
    public static final double MAX_AMOUNT = 10000;
    public static final int DELAY = 10;

    public static void main(String[] args) {
        Bank bank = new Bank(NACCOUNTS, INITIAL_BALANCE);
        for (int i=0; i< NACCOUNTS; i++){
            int fromAccount = i;

            Runnable r = () ->{
                try {
                    while (true){
                        int toAccount = (int) (bank.size() * Math.random());
                        double amount = MAX_AMOUNT * Math.random();
                        bank.transfer(fromAccount,toAccount,amount);
                        Thread.sleep((long) (DELAY *Math.random()));
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            Thread t = new Thread(r);
            t.start();
        }
    }

}
