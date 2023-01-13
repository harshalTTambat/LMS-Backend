package com.LMSbackend.LMS_backendApplication.Repository;

import com.LMSbackend.LMS_backendApplication.Models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    List<Author> findByName(String name);
}
