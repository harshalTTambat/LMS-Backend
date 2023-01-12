package com.LMSbackend.LMS_backendApplication.RequestDTO;

import com.LMSbackend.LMS_backendApplication.Enums.Genre;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookRequestDto {

    private String name;

    private Genre genre;

    private int authorId;
}
