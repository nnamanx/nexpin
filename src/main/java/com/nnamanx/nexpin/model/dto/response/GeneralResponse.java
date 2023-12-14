package com.nnamanx.nexpin.model.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GeneralResponse {

    String message;
    HttpStatus status;

}