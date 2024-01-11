package com.nnamanx.nexpin.model.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginClientResponse {

    Long id;
    String fullName;
    String token;  //jwt

}
