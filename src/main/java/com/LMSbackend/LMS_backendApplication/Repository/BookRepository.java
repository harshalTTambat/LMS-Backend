package com.LMSbackend.LMS_backendApplication.Repository;

import com.LMSbackend.LMS_backendApplication.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
