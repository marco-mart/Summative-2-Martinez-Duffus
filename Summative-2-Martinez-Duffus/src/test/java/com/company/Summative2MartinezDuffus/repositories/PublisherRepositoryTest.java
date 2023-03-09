package com.company.Summative2MartinezDuffus.repositories;

import com.company.Summative2MartinezDuffus.models.Author;
import com.company.Summative2MartinezDuffus.models.Book;
import com.company.Summative2MartinezDuffus.models.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PublisherRepositoryTest {

    @Autowired
    PublisherRepository repo;

    @Before
    public void SetUp() throws Exception {
        repo.deleteAll();
    }

    @Test
    public void ShouldCreateAPublisher () throws Exception{
        Publisher publisher = new Publisher();
        Set<Book> books = new HashSet<>();

        publisher.setName("epic");
        publisher.setStreet("11213 epic street");
        publisher.setBooks(books);
        publisher.setState("CA");
        publisher.setCity("LA");
        publisher.setPostalCode("11123");
        publisher.setPhone("123-456-789");
        publisher.setEmail("epic@gmail.com");


        publisher = repo.save(publisher);

        Optional<Publisher> publisher1 = repo.findById(publisher.getId());

        assertEquals(publisher1.get(),publisher);

    }

    @Test
    public void ShouldUpdateAPublisher() throws Exception {
        Publisher publisher = new Publisher();
        Set<Book> books = new HashSet<>();

        publisher.setName("epic");
        publisher.setStreet("11213 epic street");
        publisher.setBooks(books);
        publisher.setState("CA");
        publisher.setCity("LA");
        publisher.setPostalCode("11123");
        publisher.setPhone("123-456-789");
        publisher.setEmail("epic@gmail.com");

        Publisher publisher1 = repo.save(publisher);


        publisher1.setName("swag");

        Publisher publisher2 = repo.save(publisher1);

        assertEquals(publisher2,publisher1);


    }

    @Test
    public void ShouldDeleteAPublisher () throws Exception {
        Publisher publisher = new Publisher();
        Set<Book> books = new HashSet<>();

        publisher.setName("epic");
        publisher.setStreet("11213 epic street");
        publisher.setBooks(books);
        publisher.setState("CA");
        publisher.setCity("LA");
        publisher.setPostalCode("11123");
        publisher.setPhone("123-456-789");
        publisher.setEmail("epic@gmail.com");

        publisher = repo.save(publisher);

        repo.deleteById(publisher.getId());

        Optional<Publisher> publisher1 = repo.findById(publisher.getId());

        assertFalse(publisher1.isPresent());

    }

    @Test
    public void ShouldFindAPublisherById() throws Exception {

        Publisher publisher = new Publisher();
        Set<Book> books = new HashSet<>();

        publisher.setName("epic");
        publisher.setStreet("11213 epic street");
        publisher.setBooks(books);
        publisher.setState("CA");
        publisher.setCity("LA");
        publisher.setPostalCode("11123");
        publisher.setPhone("123-456-789");
        publisher.setEmail("epic@gmail.com");

        publisher = repo.save(publisher);

        Optional<Publisher> publisher1 = repo.findById(publisher.getId());

        assertEquals(publisher1.get(),publisher);


    }

    @Test
    public void ShouldFindAllPublishers () throws Exception {

        Publisher publisher = new Publisher();
        Set<Book> books = new HashSet<>();

        publisher.setName("epic");
        publisher.setStreet("11213 epic street");
        publisher.setBooks(books);
        publisher.setState("CA");
        publisher.setCity("LA");
        publisher.setPostalCode("11123");
        publisher.setPhone("123-456-789");
        publisher.setEmail("epic@gmail.com");

        publisher = repo.save(publisher);

        List<Publisher> publisherList = new ArrayList<>();

        publisherList.add(publisher);

        List<Publisher> publisherList2 = repo.findAll();

        assertEquals(publisherList2,publisherList);
    }





}