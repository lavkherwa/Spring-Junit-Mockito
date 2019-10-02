package com.example.junit;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.junit.Service.TaxService;

@RunWith(SpringRunner.class)
public class TaxServiceTest {

	private TaxService service = new TaxService();

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
