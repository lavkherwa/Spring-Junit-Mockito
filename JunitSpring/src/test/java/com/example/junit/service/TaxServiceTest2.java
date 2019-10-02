package com.example.junit.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.junit.service.TaxBracketService;
import com.example.junit.service.TaxService2;

@RunWith(SpringRunner.class)
public class TaxServiceTest2 {

	private TaxService2 service;

	/*
	 * Before is used, So that it will be initialize always before running any test
	 */
	@Before
	public void init() {
		TaxBracketService taxBracketService = new TaxBracketService();
		service = new TaxService2();

		/* Dependency injection */
		service.setBracketService(taxBracketService);
	}

	@Test
	public void testGetTaxBracket() {
		final String taxBracket = service.getTaxBracket(1000);

		assertThat(taxBracket).isEqualTo("MEDIUM");
	}

	@Test
	public void testAllTaxBrackets() {
		final List<String> allTaxBrackets = service.allTaxBrackets();

		assertThat(allTaxBrackets).isNotEmpty();
		assertThat(allTaxBrackets).contains("LOW", "MEDIUM", "HIGH");
	}

}
