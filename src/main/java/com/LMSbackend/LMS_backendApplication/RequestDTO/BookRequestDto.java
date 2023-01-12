package com.LMSbackend.LMS_backendApplication.RequestDTO;

import com.LMSbackend.LMS_backendApplication.Enums.Genre;
import lombok.Data;


@Data
public class BookRequestDto {

    private String name;

    private Genre genre;

    private int authorId;
}
