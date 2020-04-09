package ru.progwards.java2.lessons.threads.app.service.impl;

import ru.progwards.java2.lessons.annotation.Dependency;
import ru.progwards.java2.lessons.threads.app.Store;
import ru.progwards.java2.lessons.threads.app.model.Account;
import ru.progwards.java2.lessons.threads.app.service.StoreService;

import java.util.Collection;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


@Dependency(name = "StoreServiceImpl")

public class StoreServiceImpl implements StoreService, Runnable {

    Lock lock = new ReentrantLock();

    @Override
    public Account get(String id) {
        lock.lock();
        try {
            Account account = Store.getStore().get(id);
            if (account == null) {
                throw new RuntimeException("Account not found by id:" + id);
            }
            return account;
        }finally {
            lock.unlock();
        }
    }

    @Override
    public Collection<Account> get() {
        lock.lock();
        try {
            if (Store.getStore().size() == 0) {
                throw new RuntimeException("Store is empty");
            }
            return Store.getStore().values();
        }finally {
            lock.unlock();
        }
    }

    @Override
    public void delete(String id) {
        lock.lock();
        try {
            if (Store.getStore().get(id) == null) {
                throw new RuntimeException("Account not found by id:" + id);
            }
            Store.getStore().remove(id);
        }finally {
            lock.unlock();
        }
    }

    @Override
    public void insert(Account account) {
        lock.lock();
        try {
            Store.getStore().put(account.getId(), account);
        }finally {
            lock.unlock();
        }
    }

    @Override
    public void update(Account account) {
        lock.lock();
        try {
            if (Store.getStore().get(account.getId()) == null) {
                throw new RuntimeException("Account not found by id:" + account.getId());
            }
        }finally {
            lock.unlock();
        }
        this.insert(account);
    }

    @Override
    public void run() {

    }
}