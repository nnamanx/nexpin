package com.nnamanx.nexpin.model.dto.response;

import com.nnamanx.nexpin.model.entity.TransactionType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TransactionResponse {

    Long transaction_id;
    Long acc_id;
    Double amount;
    TransactionType transactionType;
    LocalDateTime transactionDate;
}
