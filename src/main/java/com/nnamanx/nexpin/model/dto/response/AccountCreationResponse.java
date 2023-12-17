package com.nnamanx.nexpin.model.dto.response;

import com.nnamanx.nexpin.model.entity.AccountType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountCreationResponse {

    Long acc_id;
    Long client_id;
    String acc_number;
    Double balance;
    AccountType accountType;
    String currency;
}
