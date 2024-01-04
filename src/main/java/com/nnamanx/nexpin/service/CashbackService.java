package com.nnamanx.nexpin.service;

import com.nnamanx.nexpin.model.entity.Cashback;

import java.util.List;

public interface CashbackService {

    Cashback recordCashback(Cashback cashback);
    List<Cashback> getCashbacksForTransaction(Long transactionId);
}
