package com.nnamanx.nexpin.model.dto.response;

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
    LocalDateTime transactionDate;
}
