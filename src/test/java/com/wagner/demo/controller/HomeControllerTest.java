package com.wagner.demo.controller;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:root-context.xml", "classpath:spring-mvc-servlet.xml"})
@WebAppConfiguration
public class HomeControllerTest {
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void home() throws Exception{
		mockMvc.perform(get("/"))
        .andExpect(status().isOk())
        .andExpect(view().name("home"))
        .andExpect(forwardedUrl("/WEB-INF/views/home.jsp"))
        .andExpect(model().attributeExists("seekerConfig"));
	}
	
	@Test
	public void aspectShouldHaveBeenCalled() throws Exception{
        mockMvc.perform(post("/")
                .param("arrayASize", "1000")
                .param("arrayBSize", "1000")
                .param("arrayAIntoHashSet", "true")
        )
	    .andExpect(status().isOk())
	    .andExpect(view().name("home"))
	    .andExpect(forwardedUrl("/WEB-INF/views/home.jsp"))
	    .andExpect(model().attributeExists("seekerData"))
	    .andExpect(model().attribute("seekerData", hasProperty("executionTime", notNullValue())))
	    .andExpect(model().attribute("seekerData", hasProperty("executionTimeNaiveMethod", notNullValue())));
	}
}
