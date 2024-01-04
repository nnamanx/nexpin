package com.nnamanx.nexpin.service.impl;

import com.nnamanx.nexpin.model.entity.Transaction;
import com.nnamanx.nexpin.reposiotry.TransactionRepository;
import com.nnamanx.nexpin.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Override
    public Transaction recordTransaction(Transaction transaction) {
        return null;
    }

    @Override
    public List<Transaction> getAllTransactionsForAccount(Long accountId) {
        return null;
    }

    @Override
    public Transaction getTransactionById(Long transactionId) {
        return null;
    }
}
