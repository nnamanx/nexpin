package com.nnamanx.nexpin.model.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClientResponse {

    Long id;
    String username;
    String fullName;
    String phoneNumber;
    String email;
    Boolean isActive;

}
