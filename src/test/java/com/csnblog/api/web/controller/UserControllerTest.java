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

import com.csnblog.api.web.mapper.UserMapper;
import com.csnblog.api.web.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class UserControllerTest {
	private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private UserMapper userMapper;

    @Autowired
    private WebApplicationContext ctx;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    public void 유저_저장() throws Exception {
    	MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.put("/users")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"version\":\"10.0\",\"param\":{\"user_name\":\"user_name\",\"password\":\"password\",\"user_type\":\"1\"}}"))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
    }


//         	private String user_name;
//		    private String password;
//		    private String user_type;
//		    private String reg_date;
}