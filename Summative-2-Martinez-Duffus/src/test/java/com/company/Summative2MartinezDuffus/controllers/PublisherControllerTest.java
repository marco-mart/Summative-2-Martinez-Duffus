package com.company.Summative2MartinezDuffus.controllers;

import com.company.Summative2MartinezDuffus.models.Publisher;
import com.company.Summative2MartinezDuffus.repositories.PublisherRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashSet;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PublisherController.class)
public class PublisherControllerTest
{
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    PublisherRepository publisherRepository;

    private ObjectMapper mapper = new ObjectMapper();

    /**
     * Tests creating a new Publisher record and its response
     *
     * HTTP Method: POST
     * Endpoint: "/publishers"
     * Request body: new Publisher object
     * Response body: newly added Publisher object
     *
     * Response Status: 201 Created
     */
    @Test
    public void shouldCreateNewPublisher() throws Exception {

        // ARRANGE
        Publisher publisher = new Publisher();
        publisher.setName("Foxware");
        publisher.setStreet("Ann Ave");
        publisher.setCity("Los Angeles");
        publisher.setState("CA");
        publisher.setPostalCode("78952");
        publisher.setPhone("1-(816)255-4849");
        publisher.setEmail("bestpublisher@publishing.org");
        publisher.setBooks(new HashSet<>());

        String publisherJson = mapper.writeValueAsString(publisher);

        // ACT
        mockMvc.perform(
                        post("/publishers")                          // Perform the POST request
                                .content(publisherJson)                            // Set the request body
                                .contentType(MediaType.APPLICATION_JSON)       // Tell the server that it is in JSON format
                )
                .andDo(print())                                // Print results to console
                .andExpect(status().isCreated());              // Assert status code is 201
    }

    /**
     * Tests updating an existing Publisher record
     *
     * HTTP Method: PUT
     * Endpoint: "/publishers"
     * Request body: updated Publisher object
     * Response body: newly updated Publisher object
     *
     * Response Status: 204 No Content
     */
    @Test
    public void shouldUpdatePublisher() throws Exception
    {
        // ARRANGE
        Publisher publisher = new Publisher();
        publisher.setName("Epic");
        publisher.setStreet("1206 Frenger St");
        publisher.setCity("Las Cruces");
        publisher.setState("NM");
        publisher.setPostalCode("98564");
        publisher.setPhone("1-(575)489-1275");
        publisher.setEmail("oldcreeekpublishing@publishing.org");
        publisher.setBooks(new HashSet<>());

        String publisherJson = mapper.writeValueAsString(publisher);

        // PUT and POST on the repository side is the same function

        // ACT
        mockMvc.perform(
                        put("/publishers")                                 // Perform the PUT request
                                .content(publisherJson)                           // Set the request body
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