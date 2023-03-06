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

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
    public void shouldCreateNewCustomer() throws Exception {

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

}