package com.company.Summative2MartinezDuffus.controllers;

import com.company.Summative2MartinezDuffus.models.Author;
import com.company.Summative2MartinezDuffus.repositories.AuthorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AuthorController.class)
public class AuthorControllerTest
{
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    AuthorRepository customerRepository;

    private ObjectMapper mapper = new ObjectMapper();

    /**
     * Tests creating a new Author record and its response
     *
     * HTTP Method: POST
     * Endpoint: "/authors"
     * Request body: new Author object
     * Response body: newly added Author object
     *
     * Response Status: 201 Created
     */
    @Test
    public void shouldCreateNewAuthor() throws Exception {

        // ARRANGE
        Author author = new Author();
        author.setFirstName("Joe");
        author.setLastName("Shmoe");
        author.setStreet("102 Main St");
        author.setCity("Philadelphia");
        author.setState("Pennsylvania");
        author.setEmail("flyeaglesfly1@gmail.com");
        author.setPhone("1-(215)619-3465");
        author.setPostalCode("19019");

        String authorJson = mapper.writeValueAsString(author);

        // ACT
        mockMvc.perform(
                        post("/authors")                          // Perform the POST request
                                .content(authorJson)                            // Set the request body
                                .contentType(MediaType.APPLICATION_JSON)       // Tell the server that it is in JSON format
                )
                .andDo(print())                                // Print results to console
                .andExpect(status().isCreated());              // Assert status code is 201
    }

    /**
     * Tests updating an existing Author record
     *
     * HTTP Method: PUT
     * Endpoint: "/authors"
     * Request body: updated Author object
     * Response body: newly updated Author object
     *
     * Response Status: 204 No Content
     */
    @Test
    public void shouldUpdateAuthor() throws Exception
    {
        // ARRANGE

        // PUT and POST on the repository side is the same function

        // Create new Author
        Author author = new Author();
        author.setFirstName("Marco");
        author.setLastName("Martinez");
        author.setStreet("1012 S Silver Ave");
        author.setCity("Deming");
        author.setState("NM");
        author.setEmail("nmfresh@gmail.com");
        author.setPhone("1-(575)123-4567");
        author.setPostalCode("88030");

        String authorJson = mapper.writeValueAsString(author);

        // ACT
        mockMvc.perform(
                        put("/authors")                                 // Perform the PUT request
                                .content(authorJson)                           // Set the request body
                                .contentType(MediaType.APPLICATION_JSON)            // Tell the server that it is JSON format
                )
                .andDo(print())                                             // Print results to console
                .andExpect(status().isNoContent());                         // Assert status code is 204

    }

    /**
     * Tests Deleting an existing Author
     *
     * HTTP Method: DELETE
     * Endpoint: "/authors/{id}"
     * Request body: n/a
     * Response body: n/a
     *
     * Response Status: 204 No Content
     */
    @Test
    public void shouldDeleteAuthor() throws Exception
    {
        // ARRANGE

        // Because we test the repository elsewhere, we only test for the correct response.

        // ACT
        mockMvc.perform(
                        delete("/authors/1")                        // Perform DELETE
                )
                .andDo(print())                                         // Print results to Console
                .andExpect(status().isNoContent());                     // Assert status code 204

    }

    /**
     * Tests getting an Author by id
     *
     * HTTP Method: GET
     * Endpoint: "/authors/{id}"
     * Request body: n/a
     * Response body: Author (if found)
     *
     * Response Status: 200 Ok
     */
    @Test
    public void shouldGetAuthorById() throws Exception
    {
        // ARRANGE

        // Because we test the repository elsewhere, we only test for the correct response.

        // ACT

        mockMvc.perform(
                        get("/authors/1")
                )
                .andDo(print())
                .andExpect(status().isOk());
    }

    /**
     * Tests getting all Authors
     *
     * HTTP Method: GET
     * Endpoint: "/authors"
     * Request body: n/a
     * Response body: Author (if found)
     *
     * Response Status: 200 Ok
     */
    @Test
    public void shouldGetAllAuthors() throws Exception
    {
        // ARRANGE

        // Because we test the repository elsewhere, we only test for the correct response.

        // ACT

        mockMvc.perform(
                        get("/authors")
                )
                .andDo(print())
                .andExpect(status().isOk());
    }

}