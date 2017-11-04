package com.csnblog.api.web.controller;

import com.csnblog.api.web.mapper.SampleMapper;
import com.csnblog.api.web.service.SampleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(SampleController.class)
public class SampleControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SampleService sampleService;

    @MockBean
    private SampleMapper sampleMapper;

    @Test
    public void sampleRequestController_with_parameter() throws Exception {
        this.mockMvc.perform(post("/sample/request").contentType(MediaType.APPLICATION_JSON)
                .content("{\"version\":\"10.0\",\"param\":{\"name\":\"name\",\"age\":29}}"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("{\"check\":true}")))
                .andExpect(content().string(containsString("success")));
    }

    @Test
    public void sampleRequestController_with_parameter_collection() throws Exception {
        this.mockMvc.perform(post("/sample/request/collection").contentType(MediaType.APPLICATION_JSON)
                .content("{\"version\":\"10.0\",\"param\":{\"persons\":[{\"name\":\"name\",\"age\":29}]}}"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"outerCheck\":true")))
                .andExpect(content().string(containsString("\"innerCheck\":true")))
                .andExpect(content().string(containsString("success")));
    }
}