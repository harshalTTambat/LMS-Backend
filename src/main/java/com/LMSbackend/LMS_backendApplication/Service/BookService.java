package com.LMSbackend.LMS_backendApplication.Service;

import com.LMSbackend.LMS_backendApplication.Converters.bookConverter;
import com.LMSbackend.LMS_backendApplication.Models.Author;
import com.LMSbackend.LMS_backendApplication.Models.Book;
import com.LMSbackend.LMS_backendApplication.Repository.AuthorRepository;
import com.LMSbackend.LMS_backendApplication.Repository.BookRepository;
import com.LMSbackend.LMS_backendApplication.RequestDTO.BookRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BookService {
    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    public String addBook(BookRequestDto bookRequestDto)
    {
        try{
            // setting name and genre for book
            Book book = bookConverter.convertDtoToBookEntity(bookRequestDto);

            // we have authorId from postman
            int authorId = bookRequestDto.getAuthorId();
            //  to set the author for book
            Author author = authorRepository.findById(authorId).get();
            book.setAuthor(author);

            // book list should also update
            List<Book> currentBooksList = author.getBooksWritten();
            currentBooksList.add(book);
            author.setBooksWritten(currentBooksList);
// need to save the author first before saving book
            authorRepository.save(author);

            // save book not needed, because bidirectional relationship
            //bookRepository.save(book);
            // automatically save by parent (Author) because author updated and save

        }
        catch (Exception e)
        {
            log.info("book adding failed");
            return "sorry.. can not add book";
        }
        return "Book added successfully";
    }

}
