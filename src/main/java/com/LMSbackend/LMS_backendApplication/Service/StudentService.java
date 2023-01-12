package com.LMSbackend.LMS_backendApplication.Service;

import com.LMSbackend.LMS_backendApplication.Enums.CardStatus;
import com.LMSbackend.LMS_backendApplication.Models.Card;
import com.LMSbackend.LMS_backendApplication.Models.Student;
import com.LMSbackend.LMS_backendApplication.Repository.StudentRepository;
import com.LMSbackend.LMS_backendApplication.RequestDTO.StudentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    CardService cardService;

    public String createStudent(StudentRequestDto studentRequestDto)
    {
       // need to convert DTO to Student Entity type object to add in database

        Student student = new Student();
        student.setAge(studentRequestDto.getAge());
        student.setName(studentRequestDto.getName());
        student.setCountry(studentRequestDto.getCountry());
        student.setEmail(studentRequestDto.getEmail());

        // when student created , card should automatically save
        // but for saving automatically we must have to create card
        Card newCard = cardService.createCard(student);

        // for Bidirectional relation , need to set the card
        student.setCard(newCard);

        // saving student at student repository/ student database
        studentRepository.save(student);

        // because of bidirectional relationship, card will save automatically in card database
        // cardRepository.save(newCard) --> NOT Required

        return "Student & card added successfully ";
    }
}
