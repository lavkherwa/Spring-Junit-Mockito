package com.example.junit;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.junit.Service.TaxBracketService;
import com.example.junit.Service.TaxService2;

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
	public void brackets() {
		final String taxBracket = service.getTaxBracket(1000);

		assertThat(taxBracket).isEqualTo("MEDIUM");
	}

	@Test
	public void allBrackets() {
		final List<String> allTaxBrackets = service.allTaxBrackets();

		assertThat(allTaxBrackets).isNotEmpty();
		assertThat(allTaxBrackets).contains("LOW", "MEDIUM", "HIGH");
	}

}
