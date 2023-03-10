package com.company.Summative2MartinezDuffus.controllers;

import com.company.Summative2MartinezDuffus.models.Author;
import com.company.Summative2MartinezDuffus.models.Book;
import com.company.Summative2MartinezDuffus.models.Publisher;
import com.company.Summative2MartinezDuffus.repositories.AuthorRepository;
import com.company.Summative2MartinezDuffus.repositories.BookRepository;
import com.company.Summative2MartinezDuffus.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class GraphController {

    @Autowired
    BookRepository BookRepo;

    @Autowired
    AuthorRepository AuthorRepo;

    @Autowired
    PublisherRepository PublisherRepo;

    @Query
    public Publisher findPublisherById(@Argument int id) {
        Optional<Publisher> publisher = PublisherRepo.findById(id);

        if (publisher.isPresent()){
            return publisher.get();
        } else {
            return null;
        }
    }

    @Query
    public Author findAuthorById(@Argument int id){
        Optional<Author> author= AuthorRepo.findById(id);

        if (author.isPresent()){
            return author.get();
        } else {
            return null;
        }
    }

    @Query
    public Book findBookById(@Argument int id){
        Optional<Book> book = BookRepo.findById(id);

        if (book.isPresent()){
            return book.get();
        } else {
            return null;
        }
    }

}
