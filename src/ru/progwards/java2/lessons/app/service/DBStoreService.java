package ru.progwards.java2.lessons.app.service;

import ru.progwards.java2.lessons.app.Store;
import ru.progwards.java2.lessons.app.model.Account;
import ru.progwards.java2.lessons.app.service.StoreService;

import java.util.Collection;

public class DBStoreService implements StoreService {
    @Override
    public Account get(String id) {
        return Store.getAccountDB(id);
    }

    @Override
    public Collection<Account> get() {
        return null;
    }

    @Override
    public void delete(String id) {
        Store.deleteAccountDB(id);
    }

    @Override
    public void insert(Account account) {
        Store.insertAccountDB(account);
    }

    @Override
    public void update(Account account) {
        Store.updateAccountDB(account);
    }
}
