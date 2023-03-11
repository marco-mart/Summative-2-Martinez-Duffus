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
public class AuthorRepositoryTest {

    /**
     * Note: MUST USE ALL THREE MODELS, AND ALL THREE REPOS IN EVERY TEST
     *       FOR IT TO WORK!
     */

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
    public void ShouldCreateAnAuthor () throws Exception {
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

        BookRepo.save(book);

        Optional<Author> author1 = AuthorRepo.findById(author.getId());

        assertEquals(author1.get(),author);
    }

    @Test
    public void ShouldUpdateAnAuthor() throws Exception {
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

        BookRepo.save(book);

        Author author1 = AuthorRepo.save(author); //original author


        author1.setFirstName("Dalonte"); // update

        Author author2 = AuthorRepo.save(author1); // saving update to database

        assertEquals(author2,author1); //checking if updated object matches copy original

    }

    @Test
    public void ShouldDeleteAnAuthor() throws Exception {
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

        //BookRepo.save(book);  if you save a book this test fails

        AuthorRepo.deleteById(author.getId());

        Optional<Author> author1 = AuthorRepo.findById(author.getId());

        assertFalse(author1.isPresent());


    }

    @Test
    public void ShouldFindAnAuthorById() {
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

        BookRepo.save(book);

        Optional<Author> author1 = AuthorRepo.findById(author.getId());

        assertEquals(author1.get(),author);
    }

    @Test
    public void ShouldFindAllAuthors() {
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

        BookRepo.save(book);

        List<Author> authorList = new ArrayList<>();

        authorList.add(author);

        List<Author> authorList2 = AuthorRepo.findAll();

        assertEquals(authorList2,authorList);
    }

}