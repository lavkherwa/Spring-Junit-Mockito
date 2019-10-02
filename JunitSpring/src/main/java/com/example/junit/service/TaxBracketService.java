package com.example.junit.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class TaxBracketService {

	
	public List<String> all(){
		return Arrays.asList("LOW", "MEDIUM", "HIGH");
	}
	
}
