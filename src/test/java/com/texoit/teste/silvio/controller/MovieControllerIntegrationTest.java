package com.texoit.teste.silvio.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


@SpringBootTest
@AutoConfigureMockMvc
class MovieControllerIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void whenCallProducersEndpoint_themReturnsExpectedJSON() throws Exception {
		String expectedJSON = """
			{
			    "min": [
			        {
			            "producer": "Joel Silver",
			            "interval": 1,
			            "previousWin": 1990,
			            "followingWin": 1991
			        }
			    ],
			    "max": [
			        {
			            "producer": "Matthew Vaughn",
			            "interval": 13,
			            "previousWin": 2002,
			            "followingWin": 2015
			        }
			    ]
			}
			""";
		
		MvcResult mvcResult = mockMvc
			.perform(get("/movie/producers").contentType("application/json"))
			.andReturn();
		String resultJSON = mvcResult.getResponse().getContentAsString();
		
		System.out.println();
		System.out.println(resultJSON);
		System.out.println();
		
		assertThat(resultJSON).isEqualToIgnoringWhitespace(expectedJSON);
		
	}
	
	@Test
	void whenCallStudiosEndpoint_themReturnsExpectedJSON() throws Exception {
		String expectedJSON = """
			{
			    "min": [
			        {
			            "studio": "Columbia Pictures",
			            "interval": 1,
			            "previousWin": 2017,
			            "followingWin": 2018
			        },
			        {
			            "studio": "Paramount Pictures",
			            "interval": 1,
			            "previousWin": 2008,
			            "followingWin": 2009
			        },
			        {
			            "studio": "Paramount Pictures",
			            "interval": 1,
			            "previousWin": 2009,
			            "followingWin": 2010
			        },
			        {
			            "studio": "Warner Bros.",
			            "interval": 1,
			            "previousWin": 1999,
			            "followingWin": 2000
			        }
			    ],
			    "max": [
			        {
			            "studio": "Paramount Pictures",
			            "interval": 15,
			            "previousWin": 1993,
			            "followingWin": 2008
			        }
			    ]
			}
			""";
		
		MvcResult mvcResult = mockMvc
			.perform(get("/movie/studios").contentType("application/json"))
			.andReturn();
		String resultJSON = mvcResult.getResponse().getContentAsString();
		
		System.out.println();
		System.out.println(resultJSON);
		System.out.println();
		
		assertThat(resultJSON).isEqualToIgnoringWhitespace(expectedJSON);
		
	}

}
