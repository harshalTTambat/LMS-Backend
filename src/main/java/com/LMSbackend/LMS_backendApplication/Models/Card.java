package com.LMSbackend.LMS_backendApplication.Models;

import jakarta.persistence.*;

@Entity
@Table(name="Card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
