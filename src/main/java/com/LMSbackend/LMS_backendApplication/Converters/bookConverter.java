package com.LMSbackend.LMS_backendApplication.Converters;

import com.LMSbackend.LMS_backendApplication.Models.Author;
import com.LMSbackend.LMS_backendApplication.Models.Book;
import com.LMSbackend.LMS_backendApplication.RequestDTO.BookRequestDto;

public class bookConverter{

    public static Book convertDtoToBookEntity(BookRequestDto bookRequestDto)
    {
        Book book = Book.builder().
                name(bookRequestDto.getName()).
                genre(bookRequestDto.getGenre()).
                build();
        return book;

    }
}
