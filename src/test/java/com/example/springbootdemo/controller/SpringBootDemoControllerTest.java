package com.example.springbootdemo.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(SpringBootDemoController.class)
class SpringBootDemoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void should_return_hello_when_call_endpoint_given_nothing() throws Exception {
        var perform = mockMvc.perform(MockMvcRequestBuilders.get("/demo"));
        perform.andExpectAll(MockMvcResultMatchers.status().isOk(),
            MockMvcResultMatchers.content().string("hello"));

    }
}