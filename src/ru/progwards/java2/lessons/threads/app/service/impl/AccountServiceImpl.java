package ru.progwards.java2.lessons.threads.app.service.impl;

import ru.progwards.java2.lessons.annotation.Dependency;
import ru.progwards.java2.lessons.threads.app.model.Account;
import ru.progwards.java2.lessons.threads.app.service.AccountService;
import ru.progwards.java2.lessons.threads.app.service.StoreService;

@Dependency(name = "AccountServiceImpl")

public class AccountServiceImpl implements AccountService, Runnable {


    private StoreService service;

    Object obj = new Object();

    public AccountServiceImpl(){

    }

    public AccountServiceImpl(StoreService service){
        this.service = service;
    }

    @Override
    public double balance(Account account) {
        synchronized (obj) {
            return account.getAmount();
        }
    }

    @Override
    public void deposit(Account account, double amount) {
        synchronized (obj) {
            double sum = account.getAmount() + amount;
            account.setAmount(sum);
            service.update(account);
        }
    }

    @Override
    public void withdraw(Account account, double amount) {
        synchronized (obj) {
            double sum = account.getAmount() - amount;
            if (sum < 0) {
                throw new RuntimeException("Not enough money");
            }
            account.setAmount(sum);
            service.update(account);
        }
    }

    @Override
    public void transfer(Account from, Account to, double amount) {
        synchronized (obj) {
            double fromSum = from.getAmount() - amount;
            double toSum = to.getAmount() + amount;
            if (fromSum < 0) {
                throw new RuntimeException("Not enough money");
            }
            from.setAmount(fromSum);
            service.update(from);
            to.setAmount(toSum);
            service.update(to);
        }
    }

    @Override
    public void run() {

    }
}
