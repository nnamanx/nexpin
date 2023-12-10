package com.nnamanx.nexpin.model.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String card_name;

    LocalDate expire_month;
    LocalDate expire_year;
    String pan; // 16-digit number
    Integer cvc;
    Boolean is_active;

    @ManyToOne
    @JoinColumn(name = "user_id")
    Client client;

    @ManyToOne
    @JoinColumn(name = "account_id")
    Account account;

}
