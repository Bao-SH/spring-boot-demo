package com.example.springbootdemo.controller;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.example.springbootdemo.service.BookService;
import com.example.springbootdemo.utility.JsonUtility;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(SpringBootDemoController.class)
@ContextConfiguration(classes = {SpringBootDemoController.class})
@ExtendWith(MockitoExtension.class)
class SpringBootDemoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test
    void should_return_hello_when_call_endpoint_given_nothing() throws Exception {
        var perform = mockMvc.perform(MockMvcRequestBuilders.get("/demo/hello"));
        perform.andExpectAll(MockMvcResultMatchers.status().isOk(),
            MockMvcResultMatchers.content().string("hello"));

    }

    @Test
    void should_call_service_when_call_book_endpoint_given_book() throws Exception {
        var mockedReturnString = "Book test is created";
        when(bookService.createBook(any())).thenReturn(mockedReturnString);
        var requestJsonString = JsonUtility.getResourceAsString("request/create-book-request.json");
        mockMvc.perform(MockMvcRequestBuilders.post("/demo/book")
                .content(requestJsonString).contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isCreated())
            .andExpect(MockMvcResultMatchers.content().string(mockedReturnString));

    }
}