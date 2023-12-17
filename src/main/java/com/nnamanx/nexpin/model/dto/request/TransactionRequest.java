package com.nnamanx.nexpin.model.dto.request;

import com.nnamanx.nexpin.model.entity.TransactionType;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;

import static com.nnamanx.nexpin.model.constant.Constants.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Validated
public class TransactionRequest {

    @NotBlank(message = ACCOUNT_ID_URGENT)
    Long account_id;

    @NotBlank(message = AMOUNT_URGENT)
    Double amount;

    @NotBlank(message = TRANSACTION_TYPE_URGENT)
    TransactionType transactionType; // Actions: "DEPOSIT", "WITHDRAWAL"

    @NotBlank(message = CURRENCY_URGENT)
    String currency;

}
