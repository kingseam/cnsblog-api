package com.cnsblog.api.web.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class BoardControllerTest {
	private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext ctx;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    public void 게시판_전체_가져오기() throws Exception {
    	MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/board/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
    }

    @Test
    public void 게시번호_하나만_가져오기() throws Exception {
		MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/board")
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
    }

    @Test
    public void 파라매터_숫자아닌문자() throws Exception {
		MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/board/ㅁㄴㅇㅁㄴㅇ")
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isNotFound())
				.andReturn();
    }

    @Test
    public void 주소에_마지막_슬러시_추가() throws Exception {
		MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/board/")
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
    }
}