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
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String username;
    String fullName;
    String phoneNumber;
    String email;
    String password;
    Boolean is_active;

    @OneToMany(mappedBy = "client")
    List<Account> accounts;

    @ManyToOne
    @JoinColumn(name = "role_id")
    Role role;

}
