package com.LMSbackend.LMS_backendApplication.Controllers;

import com.LMSbackend.LMS_backendApplication.RequestDTO.BookRequestDto;
import com.LMSbackend.LMS_backendApplication.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/add_book")
    public ResponseEntity<String> addBook(@RequestBody()BookRequestDto bookRequestDto)
    {
        String result = bookService.addBook(bookRequestDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
