package com.LMSbackend.LMS_backendApplication.Controllers;


import com.LMSbackend.LMS_backendApplication.RequestDTO.AuthorRequestDto;
import com.LMSbackend.LMS_backendApplication.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("/create_author")
    public ResponseEntity<String> createAuthor(@RequestBody()AuthorRequestDto authorRequestDto)
    {
        String result = authorService.createAuthor(authorRequestDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
