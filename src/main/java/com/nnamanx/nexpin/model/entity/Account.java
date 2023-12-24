package com.nnamanx.nexpin.model.entity;

import com.nnamanx.nexpin.model.enums.AccountType;
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
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String acc_number;
    Double balance;
    String currency;
    Boolean is_active;

    @Enumerated(EnumType.STRING)
    @Column(name = "accounttype")
    AccountType accountType;

    @ManyToOne
    @JoinColumn(name = "client_id")
    Client client;

    @OneToMany(mappedBy = "account")
    List<Card> cards;

    @OneToMany(mappedBy = "account")
    List<Transaction> transactions;

}
