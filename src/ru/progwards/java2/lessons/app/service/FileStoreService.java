package ru.progwards.java2.lessons.app.service;

import ru.progwards.java2.lessons.app.Store;
import ru.progwards.java2.lessons.app.model.Account;

import java.util.Collection;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class FileStoreService implements StoreService{

    ReadWriteLock readWriteLock;

        public FileStoreService(){
            this.readWriteLock = new ReentrantReadWriteLock();
        }

    @Override
    public Account get(String id) {
            try {
                readWriteLock.readLock().lock();
                Account account = Store.getStore().get(id);
                return account;
            }finally {
                readWriteLock.readLock().unlock();
            }
    }


    @Override
    public Collection<Account> get() {
            try {
                readWriteLock.readLock().lock();
                if (Store.getStore().size() == 0) {
                    throw new RuntimeException("Store is empty");
                }
                return Store.getStore().values();
            }finally {
                readWriteLock.readLock().unlock();
            }
    }

    @Override
    public void delete(String id) {
            try {
                readWriteLock.writeLock().lock();
                if (Store.getStore().get(id) == null) {
                    throw new RuntimeException("Account not found by id:" + id);
                }
                Store.getStore().remove(id);
                Store.setStore();
            }finally {
                readWriteLock.writeLock().unlock();
            }
    }

    @Override
    public void insert(Account account) {
        try {
            readWriteLock.writeLock().lock();
            Store.getStore().put(account.getId(), account);
            Store.setStore();
        }finally {
            readWriteLock.writeLock().unlock();
        }
    }

    @Override
    public void update(Account account) {
            try {
                readWriteLock.writeLock().lock();
                if (Store.getStore().get(account.getId()) == null) {
                    throw new RuntimeException("Account not found by id:" + account.getId());
                }
//                this.insert(account);
                Store.setStore();
            }finally {
                readWriteLock.writeLock().unlock();
            }
    }
}
