package com.nnamanx.nexpin.service.impl;

import com.nnamanx.nexpin.model.entity.Account;
import com.nnamanx.nexpin.reposiotry.AccountRepository;
import com.nnamanx.nexpin.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public Account createAccount(Account account) {

        return accountRepository.save(account);
    }

    @Override
    public void deleteAccount(Long accountId) {

    }

    @Override
    public Account getAccountById(Long accountId) {
        return null;
    }

    @Override
    public List<Account> getAllAccountsForClient(Long clientid) {
        return null;
    }

    @Override
    public Account deposit(Long accountId, Double amount) {
        return null;
    }

    @Override
    public Account withdraw(Long accountId, Double amount) {
        return null;
    }
}
