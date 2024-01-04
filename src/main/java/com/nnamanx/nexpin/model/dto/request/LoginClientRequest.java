package com.nnamanx.nexpin.model.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;

import static com.nnamanx.nexpin.model.constant.Constants.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Validated
public class LoginClientRequest {

    @NotBlank(message = USERNAME_URGENT)
    String username;

    @NotBlank(message = FULLNAME_URGENT)
    String fullName;

    @NotBlank(message = EMAIL_URGENT)
    @Email(message = EMAIL_IS_NOT_VALID)
    String email;

    @NotBlank(message = PASSWORD_URGENT)
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = PASSWORD_REGEX
    )
    String password;
}
