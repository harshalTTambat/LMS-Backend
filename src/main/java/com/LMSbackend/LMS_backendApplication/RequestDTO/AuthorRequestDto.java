package com.LMSbackend.LMS_backendApplication.RequestDTO;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorRequestDto {

    private String name;
    private int age;
    private String country;

    @Column(unique = true)
    private String email;
}
