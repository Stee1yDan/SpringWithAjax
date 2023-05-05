package com.javatechie.spring.ajax.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Book
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String bookName;
    private String author;

}