package com.nnamanx.nexpin.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cashback{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Double refund_amount;

    // transaction_id, account_id.

}
