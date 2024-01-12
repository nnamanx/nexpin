package com.nnamanx.nexpin.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;

import static com.nnamanx.nexpin.model.constant.Messages.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Validated
public class ClientRequest {

    @NotBlank(message = FULLNAME_URGENT)
    String fullName;

    @NotBlank(message = PHONE_NUMBER_URGENT)
    @Pattern(
            regexp = "^(\\+[0-9]{1,4}[-.\\s]?)?((\\([0-9]{1,4}\\))|[0-9]{1,4})[-.\\s]?[0-9]{1,14}$",
            message = INVALID_PHONE
    )
    String phoneNumber;

    @NotBlank(message = PASSWORD_URGENT)
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = PASSWORD_REGEX
    )
    String password;
}
