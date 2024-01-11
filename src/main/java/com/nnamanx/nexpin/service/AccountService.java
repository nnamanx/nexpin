package com.nnamanx.nexpin.service;

import com.nnamanx.nexpin.model.entity.Account;

import java.util.List;

public interface AccountService {

    Account createAccount(Account account);

    void deleteAccount(Long accountId);

    Account getAccountById(Long accountId);

    List<Account> getAllAccountsForClient(Long clientid);

    Account deposit(Long accountId, Double amount);

    Account withdraw(Long accountId, Double amount);
}
