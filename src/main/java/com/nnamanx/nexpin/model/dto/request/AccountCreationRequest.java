package com.nnamanx.nexpin.model.dto.request;

import com.nnamanx.nexpin.model.enums.AccountType;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;

import static com.nnamanx.nexpin.model.constant.Messages.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Validated
public class AccountCreationRequest {

    @NotBlank(message = ID_URGENT)
    Long id;

    @NotBlank(message = ACCOUNT_TYPE_URGENT) // select bar
    AccountType accountType;

    @NotBlank(message = CURRENCY_URGENT)
    String currency;
}
