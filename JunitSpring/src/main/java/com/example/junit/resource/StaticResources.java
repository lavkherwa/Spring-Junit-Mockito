package com.example.junit.resource;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/resource")
public class StaticResources {

	@GetMapping(value = "/image", produces = MediaType.IMAGE_PNG_VALUE)
	public @ResponseBody byte[] getImage() throws IOException {
		InputStream in = getClass().getResourceAsStream("/static/image.png");
		return IOUtils.toByteArray(in);
	}

}
