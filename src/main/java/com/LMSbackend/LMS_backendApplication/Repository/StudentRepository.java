package com.LMSbackend.LMS_backendApplication.Repository;


import com.LMSbackend.LMS_backendApplication.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {


}
