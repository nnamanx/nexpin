package com.nnamanx.nexpin.service;

import com.nnamanx.nexpin.model.entity.Transaction;

import java.util.List;

public interface TransactionService {

    Transaction recordTransaction(Transaction transaction);
    List<Transaction> getAllTransactionsForAccount(Long accountId);
    Transaction getTransactionById(Long transactionId);
}
