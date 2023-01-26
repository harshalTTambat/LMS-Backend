package com.LMSbackend.LMS_backendApplication.Controllers;

import com.LMSbackend.LMS_backendApplication.Models.Student;
import com.LMSbackend.LMS_backendApplication.RequestDTO.StudentRequestDto;
import com.LMSbackend.LMS_backendApplication.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/getStudent/{email}")
    public ResponseEntity getStudentByEmail(@RequestParam("email") String email){
        studentService.getDetailsByEmail(email);
        return new ResponseEntity<>("Student details printed successfully ", HttpStatus.OK);
    }
    @GetMapping("/getStudent")
    public ResponseEntity getStudentById(@RequestParam("id") int id){
        studentService.getDetailsById(id);
        return new ResponseEntity<>("Student details printed successfully ", HttpStatus.OK);
    }


    @PutMapping("/updateStudent")
    public ResponseEntity updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
        return new ResponseEntity<>("student is updated", HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@RequestParam("id") int id){

        studentService.deleteStudent(id);
        return new ResponseEntity<>("student is deleted", HttpStatus.ACCEPTED);
    }

}
