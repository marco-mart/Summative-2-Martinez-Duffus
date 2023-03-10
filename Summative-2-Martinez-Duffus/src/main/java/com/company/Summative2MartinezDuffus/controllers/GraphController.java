package com.company.Summative2MartinezDuffus.controllers;

import com.company.Summative2MartinezDuffus.models.Author;
import com.company.Summative2MartinezDuffus.models.Book;
import com.company.Summative2MartinezDuffus.models.Publisher;
import com.company.Summative2MartinezDuffus.repositories.AuthorRepository;
import com.company.Summative2MartinezDuffus.repositories.BookRepository;
import com.company.Summative2MartinezDuffus.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
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

    @QueryMapping
    public Publisher findPublisherById(@Argument Integer id) {
        Optional<Publisher> publisher = PublisherRepo.findById(id);

        if (publisher.isPresent()){
            return publisher.get();
        } else {
            return null;
        }
    }

    @QueryMapping
    public Author findAuthorById(@Argument Integer id){
        Optional<Author> author= AuthorRepo.findById(id);

        if (author.isPresent()){
            return author.get();
        } else {
            return null;
        }
    }

    @QueryMapping
    public Book findBookById(@Argument Integer id){
        Optional<Book> book = BookRepo.findById(id);

        if (book.isPresent()){
            return book.get();
        } else {
            return null;
        }
    }

}
