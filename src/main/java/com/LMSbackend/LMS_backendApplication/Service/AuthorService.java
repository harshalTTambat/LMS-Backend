package com.LMSbackend.LMS_backendApplication.Service;

import com.LMSbackend.LMS_backendApplication.Converters.AuthorConverter;
import com.LMSbackend.LMS_backendApplication.Models.Author;
import com.LMSbackend.LMS_backendApplication.Repository.AuthorRepository;
import com.LMSbackend.LMS_backendApplication.RequestDTO.AuthorRequestDto;
import com.LMSbackend.LMS_backendApplication.ResponseDTO.AuthorResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public String createAuthor(AuthorRequestDto authorRequestDto)
    {
        try
        {
            Author author = AuthorConverter.convertDtoToEntity(authorRequestDto);
            authorRepository.save(author);
        }
        catch (Exception e)
        {
            log.info("creating author causing issue");
            return "sorry..can not create Author ";
        }
        return "Author added successfully..";
    }
    public List<AuthorResponseDto> findByName(String name)
    {
        List<Author> authors =  authorRepository.findByName(name);
        List<AuthorResponseDto> authorResponseDtos = AuthorConverter.convertEntityToDto(authors);

        return authorResponseDtos;
    }
}
