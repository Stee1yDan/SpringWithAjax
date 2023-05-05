package com.javatechie.spring.ajax.api.repository;

import com.javatechie.spring.ajax.api.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer>
{
}
