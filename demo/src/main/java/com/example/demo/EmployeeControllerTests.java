package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.security.test.context.support.WithMockUser;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class EmployeeControllerTests {
    @Autowired
    private MockMvc mvc;
    @Test
    @WithMockUser()
    public void givenNoEmployee_whenCreateEmployee_thenEmployeeCreated() throws Exception {
        mvc.perform(post("/employees").content(
            new ObjectMapper().writeValueAsString(new Employee("First", "Last"))
            .with(csrf()))
          .contentType(MediaType.APPLICATION_JSON)
          .accept(MediaType.APPLICATION_JSON))
          .andExpect(MockMvcResultMatchers.status()
            .isCreated())
          .andExpect(jsonPath("$.firstName", is("First")))
          .andExpect(jsonPath("$.lastName", is("Last")));
    }
    // other tests as necessary
}