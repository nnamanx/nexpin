package com.nnamanx.nexpin.model.dto.request;

import com.nnamanx.nexpin.model.enums.Actions;
import jakarta.validation.constraints.NotBlank;
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
public class CardManagementRequest {

    @NotBlank(message = CLIENT_ID_URGENT)
    Long client_id;

    @NotBlank(message = ACC_ID_URGENT)
    Long acc_id;

    @NotBlank(message = ACTION_URGENT)
    Actions action;
}
