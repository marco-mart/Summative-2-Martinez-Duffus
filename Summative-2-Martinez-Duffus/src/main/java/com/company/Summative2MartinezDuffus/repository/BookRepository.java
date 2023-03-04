package com.company.Summative2MartinezDuffus.repository;

import com.company.Summative2MartinezDuffus.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {


    List<Book> findAllByAuthorId(int authorId);

}
