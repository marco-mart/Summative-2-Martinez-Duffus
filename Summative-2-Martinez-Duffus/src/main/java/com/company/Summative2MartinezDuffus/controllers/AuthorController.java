package com.company.Summative2MartinezDuffus.controllers;

import com.company.Summative2MartinezDuffus.models.Author;
import com.company.Summative2MartinezDuffus.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AuthorController {

    @Autowired
    AuthorRepository repo;

    @PostMapping("/author")
    @ResponseStatus(HttpStatus.CREATED)
    public void CreateAuthor(@RequestBody Author author){
        repo.save(author);
    }

    @GetMapping("/author/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Author getAuthorById(@PathVariable int id){
        Optional<Author> author= repo.findById(id);

        if (author.isPresent()){
            return author.get();
        } else {
            return null;
        }

    }

    @GetMapping("/author")
    @ResponseStatus(HttpStatus.OK)
    public List<Author> getAllAuthors(){
        return repo.findAll();
    }

    @PutMapping("/author")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAuthor(@RequestBody Author author){
        repo.save(author);
    }

    @DeleteMapping("/author/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(@PathVariable int id){
        repo.deleteById(id);
    }


}