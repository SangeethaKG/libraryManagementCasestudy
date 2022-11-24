package com.librarymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.librarymanagement.model.Books;


@Repository
public interface BooksRepository extends JpaRepository<Books, String>{

}
