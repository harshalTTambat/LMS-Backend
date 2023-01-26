package com.LMSbackend.LMS_backendApplication.Controllers;

import com.LMSbackend.LMS_backendApplication.Models.Book;
import com.LMSbackend.LMS_backendApplication.RequestDTO.BookRequestDto;
import com.LMSbackend.LMS_backendApplication.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/getBooks")
    public ResponseEntity<List<Book>> getBooks(@RequestParam(value = "genre", required = false) String genre,
                                               @RequestParam(value = "available", required = false, defaultValue = "false") boolean available,
                                               @RequestParam(value = "author", required = false) String author){

        //find the elements of the list by yourself
        List<Book> bookList = bookService.getBooks(genre, available, author);
        return new ResponseEntity<>(bookList, HttpStatus.OK);

    }
}
