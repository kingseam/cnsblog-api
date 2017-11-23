package com.cnsblog.api.web.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class SampleControllerTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext ctx;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    public void sampleRequestController_with_parameter() throws Exception {
        this.mockMvc.perform(post("/sample/request").contentType(MediaType.APPLICATION_JSON)
                .content("{\"param\":{\"name\":\"name\",\"age\":29}}"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("{\"check\":true}")))
                .andExpect(content().string(containsString("success")));
    }

    @Test
    public void sampleRequestController_with_parameter_collection() throws Exception {
        this.mockMvc.perform(post("/sample/request/collection").contentType(MediaType.APPLICATION_JSON)
                .content("{\"param\":{\"persons\":[{\"name\":\"name\",\"age\":29}]}}"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"outerCheck\":true")))
                .andExpect(content().string(containsString("\"innerCheck\":true")))
                .andExpect(content().string(containsString("success")));
    }
}