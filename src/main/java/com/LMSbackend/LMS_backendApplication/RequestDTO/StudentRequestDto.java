package com.LMSbackend.LMS_backendApplication.RequestDTO;

import jakarta.persistence.Column;

import lombok.Data;


@Data

public class StudentRequestDto {

    private int age;

    @Column(nullable = false)
    private String name;

    private String country;

    @Column(nullable = false)
    private String email;


}
