package com.nnamanx.nexpin.service.impl;

import com.nnamanx.nexpin.model.entity.Cashback;
import com.nnamanx.nexpin.reposiotry.CashbackRepository;
import com.nnamanx.nexpin.service.CashbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CashbackServiceImpl implements CashbackService {

    private final CashbackRepository cashbackRepository;

    @Override
    public Cashback recordCashback(Cashback cashback) {

        return cashbackRepository.save(cashback);
    }

    @Override
    public List<Cashback> getCashbacksForTransaction(Long transactionId) {

        return cashbackRepository.findByTransactionId(transactionId);
    }
}
