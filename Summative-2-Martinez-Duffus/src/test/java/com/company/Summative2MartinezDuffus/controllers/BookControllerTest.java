package com.company.Summative2MartinezDuffus.controllers;

import com.company.Summative2MartinezDuffus.models.Book;
import com.company.Summative2MartinezDuffus.repositories.BookRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTest
{
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    BookRepository bookRepository;

    private ObjectMapper mapper = new ObjectMapper();

    /**
     * Tests creating a new Book record and its response
     *
     * HTTP Method: POST
     * Endpoint: "/books"
     * Request body: new Book object
     * Response body: newly added Book object
     *
     * Response Status: 201 Created
     */
    @Test
    public void shouldCreateNewBook() throws Exception {

        // ARRANGE
        Book book = new Book();
        book.setIsbn("978-3-16-148410-0");
    //    book.setPublishDate(LocalDate.of(2012, 10, 12));
        book.setTitle("Dalonte Strikes Again");
        book.setPrice(new BigDecimal("12.99"));

        String bookJson = mapper.writeValueAsString(book);

        // ACT
        mockMvc.perform(
                        post("/books")                          // Perform the POST request
                                .content(bookJson)                            // Set the request body
                                .contentType(MediaType.APPLICATION_JSON)       // Tell the server that it is in JSON format
                )
                .andDo(print())                                // Print results to console
                .andExpect(status().isCreated());              // Assert status code is 201
    }

    /**
     * Tests updating an existing Book record
     *
     * HTTP Method: PUT
     * Endpoint: "/books"
     * Request body: updated Book object
     * Response body: newly updated Book object
     *
     * Response Status: 204 No Content
     */
    @Test
    public void shouldUpdateBook() throws Exception
    {
        // ARRANGE
        Book book = new Book();
        book.setIsbn("879-1-36-147520-1");
 //       book.setPublishDate(LocalDate.of(2001, 9, 1));
        book.setTitle("Finding the Light in the Darkness");
        book.setPrice(new BigDecimal("3.99"));

        String bookJson = mapper.writeValueAsString(book);

        // PUT and POST on the repository side is the same function

        // ACT
        mockMvc.perform(
                        put("/books")                                 // Perform the PUT request
                                .content(bookJson)                           // Set the request body
                                .contentType(MediaType.APPLICATION_JSON)            // Tell the server that it is JSON format
                )
                .andDo(print())                                             // Print results to console
                .andExpect(status().isNoContent());                         // Assert status code is 204
    }

    /**
     * Tests Deleting an existing Book
     *
     * HTTP Method: DELETE
     * Endpoint: "/books/{id}"
     * Request body: n/a
     * Response body: n/a
     *
     * Response Status: 204 No Content
     */
    @Test
    public void shouldDeleteBook() throws Exception
    {
        // ARRANGE

        // Because we test the repository elsewhere, we only test for the correct response.

        // ACT
        mockMvc.perform(
                        delete("/books/1")                        // Perform DELETE
                )
                .andDo(print())                                         // Print results to Console
                .andExpect(status().isNoContent());                     // Assert status code 204

    }

    /**
     * Tests getting a Book by id
     *
     * HTTP Method: GET
     * Endpoint: "/books/{id}"
     * Request body: n/a
     * Response body: Book (if found)
     *
     * Response Status: 200 Ok
     */
    @Test
    public void shouldGetBookById() throws Exception
    {
        // ARRANGE

        // Because we test the repository elsewhere, we only test for the correct response.

        // ACT

        mockMvc.perform(
                        get("/books/1")
                )
                .andDo(print())
                .andExpect(status().isOk());
    }

    /**
     * Tests getting all Books
     *
     * HTTP Method: GET
     * Endpoint: "/books"
     * Request body: n/a
     * Response body: Book (if found)
     *
     * Response Status: 200 Ok
     */
    @Test
    public void shouldGetAllBooks() throws Exception
    {
        // ARRANGE

        // Because we test the repository elsewhere, we only test for the correct response.

        // ACT

        mockMvc.perform(
                        get("/books")
                )
                .andDo(print())
                .andExpect(status().isOk());
    }

    /**
     * Tests getting Books by Author id
     *
     * HTTP Method: GET
     * Endpoint: "/books/author/{id}"
     * Request body: n/a
     * Response body: Books (if found)
     *
     * Response Status: 200 Ok
     */
    @Test
    public void shouldGetAllBookByAuthorId() throws Exception
    {
        // ARRANGE

        // Because we test the repository elsewhere, we only test for the correct response.

        // ACT

        mockMvc.perform(
                        get("/books/author/1")
                )
                .andDo(print())
                .andExpect(status().isOk());
    }
}