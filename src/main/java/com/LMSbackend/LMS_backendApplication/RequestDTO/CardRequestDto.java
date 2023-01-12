package com.LMSbackend.LMS_backendApplication.RequestDTO;

import com.LMSbackend.LMS_backendApplication.Enums.CardStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardRequestDto {

    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;
}
