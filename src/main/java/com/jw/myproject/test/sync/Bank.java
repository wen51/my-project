package com.jw.myproject.test.sync;

import lombok.Data;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Data
public class Bank {

    private final double[] accounts;

    private Lock bankLock;

    private Condition sufficientFunds;

    public Bank(int naccounts, double initialBalance) {
        accounts = new double[naccounts];
        Arrays.fill(accounts,initialBalance);
        bankLock = new ReentrantLock();
        sufficientFunds = bankLock.newCondition();
    }

    public void transfer(int from , int to, double amount){
        bankLock.lock();
        try {
            ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<>();
            while (accounts[from] < amount){
                sufficientFunds.await();
            }
            System.out.print(Thread.currentThread());
            System.out.printf(" %10.2f from %d(%10.2f) to %d(%10.2f) ", amount,from,accounts[from],to,accounts[to]);
            accounts[from] -=amount;
            System.out.printf("from:%d(%10.2f) to:%d(%10.2f) ", from,accounts[from],to,accounts[to]);
            accounts[to] += amount;
            System.out.printf("Total Balance: %10.2f%n", getTotalBalance() );
            sufficientFunds.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bankLock.unlock();
        }
    }

    public double getTotalBalance() {
        bankLock.lock();
        try {
            double sum = 0;
            for(double i : accounts){
                sum += i;
            }
            return sum;
        } finally {
            bankLock.unlock();
        }
    }

    public int size(){
        return accounts.length;
    }
}
