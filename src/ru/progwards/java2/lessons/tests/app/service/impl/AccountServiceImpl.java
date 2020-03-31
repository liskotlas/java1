package app.service.impl;

import app.model.Account;
import app.service.AccountService;
import app.service.StoreService;

public class AccountServiceImpl implements AccountService {


    private StoreService service;

    public AccountServiceImpl(){

    }

    public AccountServiceImpl(StoreService service){
        this.service = service;
    }

    @Override
    public double balance(Account account) {
        return account.getAmount();
    }

    @Override
    public void deposit(Account account, double amount) {
        double sum = account.getAmount() + amount;
        account.setAmount(sum);
        service.update(account);
    }

    @Override
    public void withdraw(Account account, double amount) {

        double sum = account.getAmount() - amount;
        if(sum < 0){
            throw new RuntimeException("Not enough money");
        }
        account.setAmount(sum);
        service.update(account);
    }

    @Override
    public void transfer(Account from, Account to, double amount) {

        double fromSum = from.getAmount() - amount;
        double toSum = to.getAmount() + amount;
        if(fromSum < 0 ){
            throw new RuntimeException("Not enough money");
        }
        from.setAmount(fromSum);
        service.update(from);
        to.setAmount(toSum);
        service.update(to);

    }

}
