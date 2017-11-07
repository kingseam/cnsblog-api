package com.csnblog.api.web.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.csnblog.api.web.mapper.BoardMapper;
import com.csnblog.api.web.service.BoardService;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class BoardControllerTest {
	private MockMvc mockMvc;

    @MockBean
    private BoardService boardService;

    @MockBean
    private BoardMapper boardMapper;

    @Autowired
    private WebApplicationContext ctx;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    public void getAll() throws Exception {
    	MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/board/list/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
    }

    @Test
    public void get1() throws Exception {
		MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/board/list/")
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
    }
}