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
public class Services {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String organization_name;
    String service_name;
    String merchant_code;

    @OneToMany(mappedBy = "service")
    List<TransactionDetails> transactionDetails;

    @ManyToOne
    @JoinColumn(name = "account_id")
    Account account;

}