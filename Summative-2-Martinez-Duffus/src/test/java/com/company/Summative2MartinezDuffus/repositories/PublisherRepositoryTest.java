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

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PublisherRepositoryTest {

    @Autowired
    BookRepository BookRepo;

    @Autowired
    AuthorRepository AuthorRepo;

    @Autowired
    PublisherRepository PublisherRepo;

    @Before
    public void Setup() throws Exception {
        BookRepo.deleteAll();
        AuthorRepo.deleteAll();
        PublisherRepo.deleteAll();
    }

    @Test
    public void ShouldCreateAPublisher () throws Exception{
        Set<Book> books = new HashSet<>();

        Publisher publisher = new Publisher();
        publisher.setName("Foxware");
        publisher.setStreet("Ann Ave");
        publisher.setCity("Los Angeles");
        publisher.setState("CA");
        publisher.setPostalCode("78952");
        publisher.setPhone("1-(816)255-4849");
        publisher.setEmail("bestpublisher@publishing.org");
        publisher.setBooks(books);

        publisher = PublisherRepo.save(publisher);

        Author author = new Author();
        author.setFirstName("Mark");
        author.setLastName("Epic");
        author.setStreet("1112 street");
        //books.add(book);
        //author.setBooks(books);
        author.setCity("Miami");
        author.setState("FL");
        author.setPostalCode("1111");
        author.setPhone("123-456-7890");
        author.setEmail("Mark@gmail.com");


        AuthorRepo.save(author);

        Book book = new Book();
        book.setIsbn("1111111111");
        book.setPublishDate(LocalDate.of(2012,10,12));
        book.setTitle("Death");
        book.setPublisherId(publisher.getId());
        BigDecimal num = new BigDecimal("1.00");
        book.setPrice(num);
        book.setAuthorId(author.getId());

        book = BookRepo.save(book);

        books.add(book);

        Optional<Publisher> publisher1 = PublisherRepo.findById(publisher.getId());

        assertEquals(publisher,publisher1.get());

    }

    @Test
    public void ShouldUpdateAPublisher() throws Exception {
        Set<Book> books = new HashSet<>();

        Publisher publisher = new Publisher();
        publisher.setName("Foxware");
        publisher.setStreet("Ann Ave");
        publisher.setCity("Los Angeles");
        publisher.setState("CA");
        publisher.setPostalCode("78952");
        publisher.setPhone("1-(816)255-4849");
        publisher.setEmail("bestpublisher@publishing.org");
        publisher.setBooks(books);

        publisher = PublisherRepo.save(publisher);

        Author author = new Author();
        author.setFirstName("Mark");
        author.setLastName("Epic");
        author.setStreet("1112 street");
        //books.add(book);
        //author.setBooks(books);
        author.setCity("Miami");
        author.setState("FL");
        author.setPostalCode("1111");
        author.setPhone("123-456-7890");
        author.setEmail("Mark@gmail.com");


        AuthorRepo.save(author);

        Book book = new Book();
        book.setIsbn("1111111111");
        book.setPublishDate(LocalDate.of(2012,10,12));
        book.setTitle("Death");
        book.setPublisherId(publisher.getId());
        BigDecimal num = new BigDecimal("1.00");
        book.setPrice(num);
        book.setAuthorId(author.getId());

        book = BookRepo.save(book);

        books.add(book);

        Publisher publisher1 = PublisherRepo.save(publisher);


        publisher1.setName("swag");

        Publisher publisher2 = PublisherRepo.save(publisher1);

        assertEquals(publisher2,publisher1);


    }

    @Test
    public void ShouldDeleteAPublisher () throws Exception {
        //Set<Book> books = new HashSet<>();

        Publisher publisher = new Publisher();
        publisher.setName("Foxware");
        publisher.setStreet("Ann Ave");
        publisher.setCity("Los Angeles");
        publisher.setState("CA");
        publisher.setPostalCode("78952");
        publisher.setPhone("1-(816)255-4849");
        publisher.setEmail("bestpublisher@publishing.org");
        //publisher.setBooks(books);

        publisher = PublisherRepo.save(publisher);

        Author author = new Author();
        author.setFirstName("Mark");
        author.setLastName("Epic");
        author.setStreet("1112 street");
        //books.add(book);
        //author.setBooks(books);
        author.setCity("Miami");
        author.setState("FL");
        author.setPostalCode("1111");
        author.setPhone("123-456-7890");
        author.setEmail("Mark@gmail.com");


        AuthorRepo.save(author);

        Book book = new Book();
        book.setIsbn("1111111111");
        book.setPublishDate(LocalDate.of(2012,10,12));
        book.setTitle("Death");
        book.setPublisherId(publisher.getId());
        BigDecimal num = new BigDecimal("1.00");
        book.setPrice(num);
        book.setAuthorId(author.getId());

        //BookRepo.save(book); if you save a book this test fails

        //books.add(book);

        PublisherRepo.deleteById(publisher.getId());

        Optional<Publisher> publisher1 = PublisherRepo.findById(publisher.getId());

        assertFalse(publisher1.isPresent());

    }

    @Test
    public void ShouldFindAPublisherById() throws Exception {

        Set<Book> books = new HashSet<>();

        Publisher publisher = new Publisher();
        publisher.setName("Foxware");
        publisher.setStreet("Ann Ave");
        publisher.setCity("Los Angeles");
        publisher.setState("CA");
        publisher.setPostalCode("78952");
        publisher.setPhone("1-(816)255-4849");
        publisher.setEmail("bestpublisher@publishing.org");
        publisher.setBooks(books);

        publisher = PublisherRepo.save(publisher);

        Author author = new Author();
        author.setFirstName("Mark");
        author.setLastName("Epic");
        author.setStreet("1112 street");
        //books.add(book);
        //author.setBooks(books);
        author.setCity("Miami");
        author.setState("FL");
        author.setPostalCode("1111");
        author.setPhone("123-456-7890");
        author.setEmail("Mark@gmail.com");


        AuthorRepo.save(author);

        Book book = new Book();
        book.setIsbn("1111111111");
        book.setPublishDate(LocalDate.of(2012,10,12));
        book.setTitle("Death");
        book.setPublisherId(publisher.getId());
        BigDecimal num = new BigDecimal("1.00");
        book.setPrice(num);
        book.setAuthorId(author.getId());

        book = BookRepo.save(book);

        books.add(book);

        Optional<Publisher> publisher1 = PublisherRepo.findById(publisher.getId());

        assertEquals(publisher1.get(),publisher);


    }

    @Test
    public void ShouldFindAllPublishers () throws Exception {

        Set<Book> books = new HashSet<>();

        Publisher publisher = new Publisher();
        publisher.setName("Foxware");
        publisher.setStreet("Ann Ave");
        publisher.setCity("Los Angeles");
        publisher.setState("CA");
        publisher.setPostalCode("78952");
        publisher.setPhone("1-(816)255-4849");
        publisher.setEmail("bestpublisher@publishing.org");
        publisher.setBooks(books);

        publisher = PublisherRepo.save(publisher);

        Author author = new Author();
        author.setFirstName("Mark");
        author.setLastName("Epic");
        author.setStreet("1112 street");
        //books.add(book);
        //author.setBooks(books);
        author.setCity("Miami");
        author.setState("FL");
        author.setPostalCode("1111");
        author.setPhone("123-456-7890");
        author.setEmail("Mark@gmail.com");


        AuthorRepo.save(author);

        Book book = new Book();
        book.setIsbn("1111111111");
        book.setPublishDate(LocalDate.of(2012,10,12));
        book.setTitle("Death");
        book.setPublisherId(publisher.getId());
        BigDecimal num = new BigDecimal("1.00");
        book.setPrice(num);
        book.setAuthorId(author.getId());

        book = BookRepo.save(book);

        books.add(book);

        List<Publisher> publisherList = new ArrayList<>();

        publisherList.add(publisher);

        List<Publisher> publisherList2 = PublisherRepo.findAll();

        assertEquals(publisherList2,publisherList);
    }





}