package com.company.Summative2MartinezDuffus.controllers;

import com.company.Summative2MartinezDuffus.models.Book;
import com.company.Summative2MartinezDuffus.models.Publisher;
import com.company.Summative2MartinezDuffus.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    BookRepository repo;

    @PostMapping("/book")
    @ResponseStatus(HttpStatus.CREATED)
    public void CreateBook(@RequestBody Book book){
        repo.save(book);
    }

    @GetMapping("/book/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book getBookById(@PathVariable int id){
        Optional<Book> book = repo.findById(id);

        if (book.isPresent()){
            return book.get();
        } else {
            return null;
        }

    }

    @GetMapping("/book")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getAllBooks(){
        return repo.findAll();
    }

    @PutMapping("/book")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBook(@RequestBody Book book){
        repo.save(book);
    }

    @DeleteMapping("/book/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable int id){
        repo.deleteById(id);
    }

    @GetMapping("/book/author/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> GetBooksByAuthorId(@PathVariable int id){ //custom query
        return repo.findAllByAuthorId(id);
    }
}
