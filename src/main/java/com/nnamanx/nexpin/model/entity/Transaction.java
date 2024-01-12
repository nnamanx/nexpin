package com.nnamanx.nexpin.model.entity;

import com.nnamanx.nexpin.model.enums.TransactionType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Double amount;
    Date transaction_date;

    @ManyToOne
    @JoinColumn(name = "account_id")
    Account account;

    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "transaction_type_id")
    TransactionType transactionType;

    @OneToMany(mappedBy = "transaction")
    List<TransactionDetails> transactionDetails;

}
