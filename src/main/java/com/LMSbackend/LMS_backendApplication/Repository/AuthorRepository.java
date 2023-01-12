package com.LMSbackend.LMS_backendApplication.Repository;

import com.LMSbackend.LMS_backendApplication.Models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
