package com.LMSbackend.LMS_backendApplication.Converters;

import com.LMSbackend.LMS_backendApplication.Models.Author;
import com.LMSbackend.LMS_backendApplication.RequestDTO.AuthorRequestDto;
import com.LMSbackend.LMS_backendApplication.ResponseDTO.AuthorResponseDto;
import com.LMSbackend.LMS_backendApplication.ResponseDTO.BookResponseDto;

import java.util.ArrayList;
import java.util.List;

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
    public static List<AuthorResponseDto> convertEntityToDto(List<Author> authors)
    {
        List<AuthorResponseDto> authorResponseDtoList = new ArrayList<>();

        for (Author author: authors)
        {
            AuthorResponseDto authorResponseDto = AuthorResponseDto.builder().
                    name(author.getName()).
                    id(author.getId()).
                    country(author.getCountry()).
                    age(author.getAge()).
                    email(author.getEmail()).
                    build();
          // adding Book responseDto pending --> tricky
            // adding to list
            authorResponseDtoList.add(authorResponseDto);
        }

        return authorResponseDtoList;

    }
}
