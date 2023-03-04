package com.company.Summative2MartinezDuffus.controllers;

import com.company.Summative2MartinezDuffus.models.Author;
import com.company.Summative2MartinezDuffus.models.Publisher;
import com.company.Summative2MartinezDuffus.repository.AuthorRepository;
import com.company.Summative2MartinezDuffus.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PublisherController {

    @Autowired
    PublisherRepository repo;

    @PostMapping("/publisher")
    @ResponseStatus(HttpStatus.CREATED)
    public void CreatePublisher(@RequestBody Publisher publisher){
        repo.save(publisher);
    }

    @GetMapping("/publisher/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Publisher getPublisherById(@PathVariable int id){
        Optional<Publisher> publisher = repo.findById(id);

        if (publisher.isPresent()){
            return publisher.get();
        } else {
            return null;
        }

    }

    @GetMapping("/publisher")
    @ResponseStatus(HttpStatus.OK)
    public List<Publisher> getAllPublishers(){
        return repo.findAll();
    }

    @PutMapping("/publisher")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePublisher(@RequestBody Publisher publisher){
        repo.save(publisher);
    }

    @DeleteMapping("/publisher/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePublisher(@PathVariable int id){
        repo.deleteById(id);
    }
}