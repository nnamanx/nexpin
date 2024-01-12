package com.nnamanx.nexpin.service.impl;

import com.nnamanx.nexpin.exception.AccountNotFoundException;
import com.nnamanx.nexpin.model.entity.Account;
import com.nnamanx.nexpin.reposiotry.AccountRepository;
import com.nnamanx.nexpin.service.AccountService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.nnamanx.nexpin.model.constant.Messages.*;

@Service
@RequiredArgsConstructor
@Transactional
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public Account createAccount(Account account) {

        return accountRepository.save(account);
    }

    @Override
    @Secured("ROLE_ADMIN")
    public void deleteAccount(Long accountId) {

        accountRepository.deleteById(accountId);
    }

    @Override
    public Account getAccountById(Long accountId) {

        return accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException("Account not found with id: " + accountId));
    }

    @Override
    public List<Account> getAllAccountsForClient(Long clientid) {

        return accountRepository.findByClientId(clientid);
    }

    //  It retrieves the account by accountId, checks if the amount is positive,
    //  updates the balance, and saves the updated account.
    @Override
    public Account deposit(Long accountId, Double amount) {

        return accountRepository.findById(accountId)
                .map(account -> {
                    // Ensure that the amount is positive for a deposit
                    if (amount > 0) {
                        account.setBalance(account.getBalance() + amount);
                        return accountRepository.save(account);
                    } else {
                        throw new IllegalArgumentException(INVALID_DEPOSIT);
                    }
                })
                .orElseThrow(() -> new AccountNotFoundException("Account not found with id: " + accountId));
    }

    // It retrieves the account by accountId, checks if the withdrawal amount is positive and there is sufficient balance,
    // updates the balance, and saves the updated account.
    @Override
    public Account withdraw(Long accountId, Double amount) {

        return accountRepository.findById(accountId)
                .map(account -> {
                    // Ensure that the account has sufficient balance for withdrawal
                    if (amount > 0 && account.getBalance() >= amount) {
                        account.setBalance(account.getBalance() - amount);
                        return accountRepository.save(account);
                    } else {
                        throw new IllegalArgumentException(INVALID_WITHDRAWAL);
                    }
                })
                .orElseThrow(() -> new AccountNotFoundException("Account not found with id: " + accountId));
    }
}
