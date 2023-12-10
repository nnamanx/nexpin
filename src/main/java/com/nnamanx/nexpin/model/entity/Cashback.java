package com.nnamanx.nexpin.model.entity;

import jakarta.persistence.*;
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

    @ManyToOne
    @JoinColumn(name = "transaction_id")
     Transaction transaction;

}
