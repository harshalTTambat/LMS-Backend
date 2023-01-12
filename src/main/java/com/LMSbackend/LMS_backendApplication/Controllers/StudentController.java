package com.LMSbackend.LMS_backendApplication.Controllers;

import com.LMSbackend.LMS_backendApplication.RequestDTO.StudentRequestDto;
import com.LMSbackend.LMS_backendApplication.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/create_student")
    public ResponseEntity<String> createStudent(@RequestBody() StudentRequestDto studentRequestDto)
    {
        String ans = studentService.createStudent(studentRequestDto);
        return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }
}
