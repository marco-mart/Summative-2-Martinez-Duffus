package com.company.Summative2MartinezDuffus.repositories;

import com.company.Summative2MartinezDuffus.models.Author;
import com.company.Summative2MartinezDuffus.models.Book;
import com.company.Summative2MartinezDuffus.models.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PublisherRepositoryTest {

    @Autowired
    PublisherRepository publisherRepo;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    private Publisher publisher;
    private Author author;
    private Book book;


    @Before
    public void SetUp() throws Exception {
        publisherRepo.deleteAll();
        bookRepository.deleteAll();
        authorRepository.deleteAll();

        publisher = new Publisher();
        Set<Book> books = new HashSet<>();

        publisher.setName("epic");
        publisher.setStreet("11213 epic street");
        publisher.setBooks(books);
        publisher.setState("CA");
        publisher.setCity("LA");
        publisher.setPostalCode("11123");
        publisher.setPhone("123-456-789");
        publisher.setEmail("epic@gmail.com");

        author = new Author();


        author.setFirstName("Mark");
        author.setLastName("Epic");
        author.setStreet("1112 street");
        author.setBooks(books);
        author.setCity("Miami");
        author.setState("FL");
        author.setPostalCode("1111");
        author.setPhone("123-456-7890");
        author.setEmail("Mark@gmail.com");

        author = authorRepository.save(author);

        book = new Book();
        book.setIsbn("1111111111");
        book.setPublishDate(LocalDate.of(2012,10,12));
        book.setTitle("Death");
        book.setPublisherId(publisher.getId());
        BigDecimal num = new BigDecimal("1.00");
        book.setPrice(num);
        book.setAuthorId(author.getId());

        book = bookRepository.save(book);
    }

    @Test
    public void ShouldCreateAPublisher () throws Exception{

        Optional<Publisher> publisher1 = publisherRepo.findById(publisher.getId());

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

        Publisher publisher1 = publisherRepo.save(publisher);


        publisher1.setName("swag");

        Publisher publisher2 = publisherRepo.save(publisher1);

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

        publisher = publisherRepo.save(publisher);

        publisherRepo.deleteById(publisher.getId());

        Optional<Publisher> publisher1 = publisherRepo.findById(publisher.getId());

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

        publisher = publisherRepo.save(publisher);

        Optional<Publisher> publisher1 = publisherRepo.findById(publisher.getId());

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

        publisher = publisherRepo.save(publisher);

        List<Publisher> publisherList = new ArrayList<>();

        publisherList.add(publisher);

        List<Publisher> publisherList2 = publisherRepo.findAll();

        assertEquals(publisherList2,publisherList);
    }





}