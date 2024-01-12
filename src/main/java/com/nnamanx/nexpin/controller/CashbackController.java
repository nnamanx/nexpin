package com.nnamanx.nexpin.controller;

import com.nnamanx.nexpin.model.entity.Cashback;
import com.nnamanx.nexpin.service.CashbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nexpin/cashback")
@RequiredArgsConstructor
public class CashbackController {

    private final CashbackService cashbackService;

    @PostMapping("/record")
    public ResponseEntity<Cashback> recordCashback(@RequestBody Cashback cashback) {
        Cashback recordedCashback = cashbackService.recordCashback(cashback);
        return ResponseEntity.status(HttpStatus.CREATED).body(recordedCashback);
    }

    @GetMapping("/for-transaction/{transactionId}")
    public ResponseEntity<List<Cashback>> getCashbacksForTransaction(@PathVariable Long transactionId) {
        List<Cashback> cashbacks = cashbackService.getCashbacksForTransaction(transactionId);
        return ResponseEntity.ok(cashbacks);
    }
}
