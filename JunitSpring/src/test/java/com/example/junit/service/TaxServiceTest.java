package com.example.junit.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.junit.service.TaxService;

@RunWith(SpringRunner.class)
public class TaxServiceTest {

	private TaxService service = new TaxService();

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
