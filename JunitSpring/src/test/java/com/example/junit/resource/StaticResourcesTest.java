package com.example.junit.resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
public class StaticResourcesTest {

	/* MockMvc can be used for testing all SERVLET related calls */
	private MockMvc mockMvc;

	/* All dependencies will be injected as mock */
	@InjectMocks
	private StaticResources staticResources;

	@Before
	public void init() {
		mockMvc = MockMvcBuilders//
				.standaloneSetup(staticResources) //
				.build();
	}

	@Test
	public void testGetImage() throws Exception {

		// Provided
		InputStream in = getClass().getResourceAsStream("/static/image.png");
		byte[] content = IOUtils.toByteArray(in);

		mockMvc//
				.perform(get("/api/resource/image")//
						.accept(MediaType.IMAGE_PNG_VALUE))//
				.andExpect(status().isOk())//
				.andExpect(content().contentType(MediaType.IMAGE_PNG_VALUE))//
				.andExpect(content().bytes(content));

	}

}
