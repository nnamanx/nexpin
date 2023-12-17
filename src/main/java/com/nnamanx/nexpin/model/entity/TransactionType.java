package com.nnamanx.nexpin.model.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TransactionType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name; // aptek
    String category; // deposit and withdrawal - create enum if needed

    @OneToMany(mappedBy = "transactionType")
    List<Transaction> transactions;

}
