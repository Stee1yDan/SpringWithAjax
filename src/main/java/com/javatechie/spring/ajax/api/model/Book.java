package com.javatechie.spring.ajax.api.model;

import jakarta.persistence.*;
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
    @SequenceGenerator(
            name = "book_seq",
            sequenceName = "book_seq"
    )
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "book_seq")
    private int id;
    private String bookName;
    private String author;

}