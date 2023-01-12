package com.LMSbackend.LMS_backendApplication.Converters;

import com.LMSbackend.LMS_backendApplication.Models.Author;
import com.LMSbackend.LMS_backendApplication.RequestDTO.AuthorRequestDto;

public class AuthorConverter {
 // static because we don't want to create object of model class again & again
    public static Author convertDtoToEntity(AuthorRequestDto authorRequestDto)
    {
        Author author = Author.builder().
                name(authorRequestDto.getName()).
                age(authorRequestDto.getAge()).
                country(authorRequestDto.getCountry()).
                email(authorRequestDto.getEmail()).
                build();
        return author;
    }
}
