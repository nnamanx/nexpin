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
public class TransactionDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String organization_service_code; //azerisiq abonent kodu (bazada saxlanilmir)

    @ManyToOne
    @JoinColumn(name = "transaction_id")
    Transaction transaction;

    @ManyToOne
    @JoinColumn(name = "services_id")
    Services services;

}
