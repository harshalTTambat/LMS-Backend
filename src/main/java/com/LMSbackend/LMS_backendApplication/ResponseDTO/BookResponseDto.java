package com.LMSbackend.LMS_backendApplication.ResponseDTO;


import com.LMSbackend.LMS_backendApplication.Enums.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class BookResponseDto {

    private String name;
    private Genre genre;

}
