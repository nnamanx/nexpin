package com.nnamanx.nexpin.controller;

import com.nnamanx.nexpin.model.entity.Transaction;
import com.nnamanx.nexpin.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nexpin/transaction")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/record")
    public ResponseEntity<Transaction> recordTransaction(@RequestBody Transaction transaction) {
        Transaction recordedTransaction = transactionService.recordTransaction(transaction);
        return ResponseEntity.status(HttpStatus.CREATED).body(recordedTransaction);
    }

    @GetMapping("/for-account/{accountId}")
    public ResponseEntity<List<Transaction>> getAllTransactionsForAccount(@PathVariable Long accountId) {
        List<Transaction> transactions = transactionService.getAllTransactionsForAccount(accountId);
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/{transactionId}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable Long transactionId) {
        Transaction transaction = transactionService.getTransactionById(transactionId);

        if (transaction != null) {
            return ResponseEntity.ok(transaction);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
