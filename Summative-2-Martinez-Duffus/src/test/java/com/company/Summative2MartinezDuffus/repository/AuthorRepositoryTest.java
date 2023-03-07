package com.company.Summative2MartinezDuffus.repository;

import com.company.Summative2MartinezDuffus.models.Author;
import com.company.Summative2MartinezDuffus.models.Book;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AuthorRepositoryTest {

    @Autowired
    AuthorRepository repo;

    @Before
    public void Setup() throws Exception {
        repo.deleteAll();
    }

    @Test
    public void ShouldCreateAnAuthor () throws Exception{
        Author author = new Author();
        Set<Book> books = new HashSet<>();


        author.setFirstName("Mark");
        author.setLastName("Epic");
        author.setStreet("1112 street");
        author.setBooks(books);
        author.setCity("Miami");
        author.setState("FL");
        author.setPostalCode("1111");
        author.setPhone("123-456-7890");
        author.setEmail("Mark@gmail.com");

        author = repo.save(author);

        Optional<Author> author1 = repo.findById(author.getId());

        assertEquals(author1.get(),author);
    }

    @Test
    public void ShouldUpdateAnAuthor() throws Exception {
        Author author = new Author();
        Set<Book> books = new HashSet<>();


        author.setFirstName("Mark");
        author.setLastName("Epic");
        author.setStreet("1112 street");
        author.setBooks(books);
        author.setCity("Miami");
        author.setState("FL");
        author.setPostalCode("1111");
        author.setPhone("123-456-7890");
        author.setEmail("Mark@gmail.com");

        Author author1 = repo.save(author); //original author


        author1.setFirstName("Dalonte"); // update

        Author author2 = repo.save(author1); // saving update to database

        assertEquals(author2,author1); //checking if updated object matches copy original

    }

    @Test
    public void ShouldDeleteAnAuthor() throws Exception {
        Author author = new Author();
        Set<Book> books = new HashSet<>();


        author.setFirstName("Mark");
        author.setLastName("Epic");
        author.setStreet("1112 street");
        author.setBooks(books);
        author.setCity("Miami");
        author.setState("FL");
        author.setPostalCode("1111");
        author.setPhone("123-456-7890");
        author.setEmail("Mark@gmail.com");

        author = repo.save(author);

        repo.deleteById(author.getId());

        Optional<Author> author1 = repo.findById(author.getId());

        assertFalse(author1.isPresent());


    }

    @Test
    public void ShouldFindAnAuthorById() {
        Author author = new Author();
        Set<Book> books = new HashSet<>();


        author.setFirstName("Mark");
        author.setLastName("Epic");
        author.setStreet("1112 street");
        author.setBooks(books);
        author.setCity("Miami");
        author.setState("FL");
        author.setPostalCode("1111");
        author.setPhone("123-456-7890");
        author.setEmail("Mark@gmail.com");

        author = repo.save(author);

        Optional<Author> author1 = repo.findById(author.getId());

        assertEquals(author1.get(),author);
    }

    @Test
    public void ShouldFindAllAuthors() {
        Author author = new Author();
        Set<Book> books = new HashSet<>();


        author.setFirstName("Mark");
        author.setLastName("Epic");
        author.setStreet("1112 street");
        author.setBooks(books);
        author.setCity("Miami");
        author.setState("FL");
        author.setPostalCode("1111");
        author.setPhone("123-456-7890");
        author.setEmail("Mark@gmail.com");

        author = repo.save(author);

        List<Author> authorList = new ArrayList<>();

        authorList.add(author);

        List<Author> authorList2 = repo.findAll();

        assertEquals(authorList2,authorList);
    }

}