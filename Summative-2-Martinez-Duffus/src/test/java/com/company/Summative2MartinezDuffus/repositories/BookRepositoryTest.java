package com.company.Summative2MartinezDuffus.repositories;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.company.Summative2MartinezDuffus.models.Author;
import com.company.Summative2MartinezDuffus.models.Book;
import com.company.Summative2MartinezDuffus.models.Publisher;
import org.aspectj.weaver.patterns.ExactTypePattern;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    BookRepository repo;

    @Autowired
    AuthorRepository AuthorRepo;

    @Autowired
    PublisherRepository PublisherRepo;


    @Before
    public void SetUp() throws Exception {
        repo.deleteAll();
        AuthorRepo.deleteAll();
        PublisherRepo.deleteAll();

    }

    //Custom query
    @Test
    public void ShouldGetAllBooksByAuthorId() {
        Publisher publisher = new Publisher();
        publisher.setName("Foxware");
        publisher.setStreet("Ann Ave");
        publisher.setCity("Los Angeles");
        publisher.setState("CA");
        publisher.setPostalCode("78952");
        publisher.setPhone("1-(816)255-4849");
        publisher.setEmail("bestpublisher@publishing.org");
        //publisher.setBooks(new HashSet<>());

        PublisherRepo.save(publisher);

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


        author = AuthorRepo.save(author);

        Book book = new Book();
        book.setIsbn("1111111111");
        book.setPublishDate(LocalDate.of(2012,10,12));
        book.setTitle("Death");
        book.setPublisherId(publisher.getId());
        BigDecimal num = new BigDecimal("1.00");
        book.setPrice(num);
        book.setAuthorId(author.getId());

        book = repo.save(book);
        List<Book> bookList = new ArrayList<>();
        bookList.add(book);
        book = repo.save(book);
        List<Book> bookList2 = repo.findAllByAuthorId(author.getId());

        assertEquals(bookList,bookList2);

    }

    @Test
    public void ShouldCreateABook() throws Exception {
        Publisher publisher = new Publisher();
        publisher.setName("Foxware");
        publisher.setStreet("Ann Ave");
        publisher.setCity("Los Angeles");
        publisher.setState("CA");
        publisher.setPostalCode("78952");
        publisher.setPhone("1-(816)255-4849");
        publisher.setEmail("bestpublisher@publishing.org");
        //publisher.setBooks(new HashSet<>());

        PublisherRepo.save(publisher);

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


        author = AuthorRepo.save(author);

        Book book = new Book();
        book.setIsbn("1111111111");
        book.setPublishDate(LocalDate.of(2012,10,12));
        book.setTitle("Death");
        book.setPublisherId(publisher.getId());
        BigDecimal num = new BigDecimal("1.00");
        book.setPrice(num);
        book.setAuthorId(author.getId());

        book = repo.save(book);




    }



}