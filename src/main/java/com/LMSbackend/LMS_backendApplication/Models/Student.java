package com.LMSbackend.LMS_backendApplication.Models;

import jakarta.persistence.*;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.sql.Date;

@Entity   // reflection of table
@Table(name="student")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;
    private int age;
    private String country;

    // when new student get created, that time stamp automatically generated
    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date lastUpdatedOn;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private Card card;

}
